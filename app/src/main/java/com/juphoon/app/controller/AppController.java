package com.juphoon.app.controller;


import com.github.pagehelper.PageInfo;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.juphoon.app.common.ServerResponse;
import com.juphoon.app.entity.App;
import com.juphoon.app.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 应用
 * Created by Juphoon on 2018/1/3.
 */
@RestController
@RequestMapping
public class AppController {

    @Autowired
    private AppService appService;

   //创建应用

    @RequestMapping(value = "/addApp", method = RequestMethod.POST)
    public ServerResponse addApp(App app) throws PinyinException {

         appService.addApp(app);
        return ServerResponse.success();
    }


    //获取应用列表
    @RequestMapping(value = "/getAppList", method = RequestMethod.GET)
    public ServerResponse getAppList(Integer page, Integer size)  {

        PageInfo<App> appPageInfo = appService.getAppList(page,size);
        return ServerResponse.success(appPageInfo);
    }

    //删除应用
    @RequestMapping(value = "/delApp", method = RequestMethod.POST)
    public ServerResponse delApp(Integer id)  {

        appService.delApp(id);
        return ServerResponse.success();
    }

    //获取应用列表
    @RequestMapping(value = "/getApps", method = RequestMethod.GET)
    public ServerResponse getAppList(String downloadPageUrlSuffix,String versionCode)  {

        List<App> appList = appService.getApps(downloadPageUrlSuffix,versionCode);
        return ServerResponse.success(appList);
    }


    @RequestMapping("/mainflist")
    public void mainflist(HttpServletResponse response,String downloadPageUrlSuffix) throws IOException {
        response.setCharacterEncoding("UTF-8");
        App installPackage = appService.getIOSAPP(downloadPageUrlSuffix);
        if (installPackage != null) {
            response.getWriter().write(getPlist(installPackage));
        }
    }
    private String getPlist(App installPackage) {
        return  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
                "<plist version=\"1.0\">\n" +
                "<dict>\n" +
                "        <key>items</key>\n" +
                "        <array>\n" +
                "                <dict>\n" +
                "                        <key>assets</key>\n" +
                "                        <array>\n" +
                "                                <dict>\n" +
                "                                        <key>kind</key>\n" +
                "                                        <string>software-package</string>\n" +
                "                                        <key>url</key>\n" +
                "                                        <string>" + installPackage.getDownloadFileUrl() + "</string>\n" +
                "                                </dict>\n" +
                "                                <dict>\n" +
                "                                        <key>kind</key>\n" +
                "                                        <string>display-image</string>\n" +
                "                                        <key>url</key>\n" +
                "                                        <string>"+installPackage.getLogUrl()+"</string>\n" +
                "                                </dict>\n" +
                "                                <dict>\n" +
                "                                        <key>kind</key>\n" +
                "                                        <string>full-size-image</string>\n" +
                "                                        <key>url</key>\n" +
                "                                        <string>"+installPackage.getLogUrl()+"</string>\n" + "</dict>\n" +
                "                        </array>\n" +
                "                        <key>metadata</key>\n" +
                "                        <dict>\n" +
                "                                <key>bundle-identifier</key>\n" +
                "                                <string>" + installPackage.getAppId() + "</string>\n" +
                "                                <key>bundle-version</key>\n" +
                "                                <string>" + installPackage.getVersionName() + "</string>\n" +
                "                                <key>kind</key>\n" +
                "                                <string>software</string>\n" +
                "                                <key>title</key>\n" +
                "                                <string>" + installPackage.getAppName() + "</string>\n" +
                "                        </dict>\n" +
                "                </dict>\n" +
                "        </array>\n" +
                "</dict>\n" +
                "</plist>";
    }


}
