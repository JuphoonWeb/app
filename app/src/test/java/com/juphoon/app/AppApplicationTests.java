package com.juphoon.app;

import com.alibaba.fastjson.JSONObject;
import com.github.stuxuhai.jpinyin.PinyinException;

import com.juphoon.app.common.JedisUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppApplicationTests {



	@Autowired
	private JedisUtils jedisUtils;

	@Test
	public void contextLoads() throws PinyinException {

	//	System.out.println(appMapper.selectByPrimaryKey(2));
		String uuid="7cecf857a95f45739685cec54d2c0d6b";

		JSONObject jsonObject = JSONObject.parseObject(jedisUtils.getJedis(uuid));
		System.out.println(jsonObject.getInteger("id"));
		System.out.println("ceshi"+jedisUtils.getJedis(uuid));
	}

}
