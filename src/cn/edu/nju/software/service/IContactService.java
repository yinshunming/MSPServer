package cn.edu.nju.software.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import cn.edu.nju.software.model.Contact;

@WebService
public interface IContactService {
	
	@WebMethod
	@WebResult(name="getContactListResult")
	public String getContactList();
	
	@WebMethod
	@WebResult(name="changeInfoResult")
	public String changeInfo(String id, String name, String namePinyin, String phone, String mobile,
			String email, String department, String nickname, String address, String note);

}
