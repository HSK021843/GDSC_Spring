package com.in28minutes.learnspringframewor.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
// ClassA를 만드는 Bean
class ClassA {
	
}

@Component
@Lazy
// initialize logic here
// ClassA를 이용해 초기화하는 ClassB
// ClassB Bean을 이용하지 않고, Spring이 자동으로 작동
// @Lazy를 이용해 자동으로 초기화되지 않게 할 수 있다 -> ClassB Bean을 이용할 때 초기화
class ClassB{
	
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		System.out.println("Some initialization logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do Something in here");
	}
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(var context = 
				new AnnotationConfigApplicationContext
				(LazyInitializationLauncherApplication.class)) {
			
			System.out.println("Initializaton of context is completed");
			
			context.getBean(ClassB.class).doSomething();

		}

	}

}
