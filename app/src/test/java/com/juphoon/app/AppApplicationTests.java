package com.juphoon.app;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.juphoon.app.mapper.AppMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppApplicationTests {

	@Autowired
	private AppMapper appMapper;


	@Test
	public void contextLoads() throws PinyinException {

	//	System.out.println(appMapper.selectByPrimaryKey(2));
		String name="http://rcs.wo.cn:8083/group2/M00/00/00/Cvr7VFpz0UGAIkGEAAADjisgtPI143.png?name=unread.png";
		System.out.println(	name.replace("http://rcs.wo.cn:8083","https://rcs.wo.cn"));
	}

}
