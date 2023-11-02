package com.in28minutes.learnspringframewor.examples.h1;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;

public class XmlConfigurationContextLauncherApplication {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(var context = 
				new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			
			context.getBean(GameRunner.class).run();

		}

	}

}
