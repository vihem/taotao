package com.taotao.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;

public class TestPagehelper {
	@Test
	public void testPagehelper() throws Exception{
		/**
		 * 1. 在mybatis的配置文件中配置分页插件：
		 * /taotao-manager-service/src/main/resources/mybatis/SqlMapConfig.xml
		 * 2. 在执行查询之前配置分页条件。使用PageHelper的静态方法
		 * 3. 执行查询
		 * 4. 取分页信息。使用PageInfo
		 */
		//2.
		PageHelper.startPage(1, 10);//第一页10条
		//3.执行查询。加载dao，扫描mapper的配置文件
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
		//创建example对象,example是查询条件
		TbItemExample example = new TbItemExample();
		//如果有查询条件
		/*
		 * Criteria criteria = example.createCriteria();
		 * criteria.and .... ;
		 */
		List<TbItem> list = itemMapper.selectByExample(example);
		//4.
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		System.out.println("总记录数：" + pageInfo.getTotal());
		System.out.println("总页数：" + pageInfo.getPages());
		System.out.println("返回的总记录数：" + list.size());
	}
}
