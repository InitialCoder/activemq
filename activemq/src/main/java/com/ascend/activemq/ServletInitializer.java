/*package com.ascend.activemq;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
*//**
 * 注意几点
 * 1.jar包中的打包方式根据自己的需要进行修改
 *
 * 2.若打包成war包,则需要继承 org.springframework.boot.context.web.SpringBootServletInitializer类,覆盖其config(SpringApplicationBuilder)方法
 *
 * 3.打包成war的话,如果打包之后的文件中没有web.xml文件的话自己可以加进去一个最简单的web.xml(只有根节点的定义,而没有子元素)，防止因缺乏web.xml文件而部署失败
 *
 *//*
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

}
*/