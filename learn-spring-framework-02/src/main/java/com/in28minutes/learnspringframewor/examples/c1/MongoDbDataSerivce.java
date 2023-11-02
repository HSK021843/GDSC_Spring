package com.in28minutes.learnspringframewor.examples.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Primary
public class MongoDbDataSerivce implements DataService{

	@Override
	public int[] retrieveData() {
		// TODO Auto-generated method stub
		return new int[] {11, 22, 33, 44, 55};
	}

}
