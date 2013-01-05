package cn.edu.nju.software.service;

import java.util.HashMap;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import cn.edu.nju.software.model.User;

@WebService
public interface ILoginService {
	@WebMethod
	@WebResult(name="loginResult")
	public String login(String username,String password);
}
