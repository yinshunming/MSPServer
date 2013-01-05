package com.java.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface HelloService {
	@WebMethod
	@WebResult(name="helloResult")
	public String sayHello(@WebParam(name = "name") String name);
}
