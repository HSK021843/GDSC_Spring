package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// Eliminate verbosity in creating Java Beans
// Public accessor methods, constructor, equals,
// hashcode and toString are automatically created.
// Released in JDK 16
record Person (String name, int age, Address address) {};

// Address - firstLine & City
record Address (String firstLine, String City) {};

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Ranga";
	}
	
	@Bean
	public int age() {
		return 15;
	}

	@Bean
	public Person person() {
		return new Person("Ravi", 20, new Address("Main Street", "Utrecht"));
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address());
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address3) {
		// name, age, address2(메서드 이름이 address2이므로)
		return new Person(name, age, address3);
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address) {
		return new Person(name, age, address);
	} // -> 2개의 address(address2, address3)로 인해 오류가 발생.
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3qalifier") Address address) {
		return new Person(name, age, address);
	}
	
	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("Baker Street", "London");
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qalifier")
	public Address address3() {
		return new Address("Motinagar", "Hyderabad");
	}
	
}
