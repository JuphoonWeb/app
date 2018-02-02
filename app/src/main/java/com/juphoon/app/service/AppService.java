package com.juphoon.app.service;

import com.github.pagehelper.PageInfo;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.juphoon.app.entity.App;

import java.util.List;

public interface AppService {


    PageInfo<App> getAppList(Integer page, Integer size);

    void addApp(App app) throws PinyinException;

    void delApp(Integer id);

    List<App> getApps(String downloadPageUrlSuffix, String versionCode);

    App getIOSAPP(String downloadPageUrlSuffix);
}
