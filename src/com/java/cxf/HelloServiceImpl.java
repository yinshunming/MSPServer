package com.java.cxf;



public class HelloServiceImpl implements HelloService{
	
	public String sayHello(String name) {
		System.out.println("++++����helloworld");
		return "Hello" + name;
	}
	
}
