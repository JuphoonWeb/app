package com.juphoon.app.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.juphoon.app.entity.App;
import com.juphoon.app.mapper.AppMapper;
import com.juphoon.app.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppMapper appMapper;

    @Value("${DownloadPageUrl}")
    private String DownloadPageUrl;


    @Override
    @Transactional
    public PageInfo<App> getAppList(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<App> appList = appMapper.getAppList(null);
        return new PageInfo<>(appList);
    }

    @Override
    public List<App> getApps(String downloadPageUrlSuffix, String versionCode) {

        List<App> appList = appMapper.getAppList(downloadPageUrlSuffix);
        if(versionCode==null)
            return  appList;

        for (int i = 0; i < appList.size(); i++) {
            App app = appList.get(i);
            if (app.getVersionCode() == versionCode || versionCode.equals(app.getVersionCode())) {
                appList.remove(app);
                appList.add(0, app);
                break;
            }
        }
        return appList;
    }

    @Override
    public App getIOSAPP(String downloadPageUrlSuffix) {

        return appMapper.getIOSApp(downloadPageUrlSuffix);
    }


    @Override
    @Transactional
    public void addApp(App app) throws PinyinException {

        app.setCreateTime(new Date());
        app.setChangeTime(new Date());
        app.setFileSize(convertFileSize(Long.parseLong(app.getFileSize())));
        if (app.getAppPassword() == null || "".equals(app.getAppPassword())) {
            app.setAppEnablePassword(0);
        } else {
            app.setAppEnablePassword(1);
        }
        String tranAppName = PinyinHelper.convertToPinyinString(app.getAppName(), "", PinyinFormat.WITHOUT_TONE);
        String downloadPageUrlSuffix;
        if (app.getAppType() == 0) {
            downloadPageUrlSuffix = tranAppName + "-android";
        } else if (app.getAppType() == 1) {
            downloadPageUrlSuffix = tranAppName + "-ios";
            String downloadFileUrl = app.getDownloadFileUrl();
            app.setDownloadFileUrl(downloadFileUrl.replace("http://rcs.wo.cn:8083", "https://rcs.wo.cn"));
        } else {
            downloadPageUrlSuffix = tranAppName + "-window";
        }
        app.setDownloadPageUrlSuffix(downloadPageUrlSuffix);
        app.setDownloadPageUrl(DownloadPageUrl + downloadPageUrlSuffix);
        appMapper.insertSelective(app);
    }

    @Override
    @Transactional
    public void delApp(Integer id) {
        appMapper.deleteByPrimaryKey(id);
    }

    public static String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;
        //%.2f 即是保留两位小数的浮点数，后面跟上对应单位就可以了
        if (size >= gb) {
            return String.format("%.2f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            //如果大于100MB就不用保留小数位啦
            return String.format(f > 100 ? "%.0f MB" : "%.2f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            //如果大于100kB就不用保留小数位了
            return String.format(f > 100 ? "%.0f KB" : "%.2f KB", f);
        } else
            return String.format("%d B", size);
    }
}

