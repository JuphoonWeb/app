package com.juphoon.app.mapper;

import com.juphoon.app.entity.AppVersion;
import com.juphoon.app.entity.vo.LatestVersionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppVersionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    AppVersion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);

    List<LatestVersionVo> getVersionList(@Param("appId") Integer appId);

    LatestVersionVo getLatestAppVersion(@Param("appId") Integer appId, @Param("appType") Integer appType);

    LatestVersionVo getIOSApp(@Param("downloadPageUrlSuffix") String downloadPageUrlSuffix);

    List<LatestVersionVo> getAppVersions(@Param("suffix") String suffix);

    int deleteByAppId(@Param("appId") Integer appId);
}