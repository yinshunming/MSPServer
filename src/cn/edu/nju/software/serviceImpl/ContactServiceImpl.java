package cn.edu.nju.software.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.nju.software.dao.IContactDAO;
import cn.edu.nju.software.model.Contact;
import cn.edu.nju.software.service.IContactService;
import cn.edu.nju.software.util.Tools;

public class ContactServiceImpl implements IContactService{
	private IContactDAO icd;
	
	public IContactDAO getIcd() {
		return icd;
	}

	public void setIcd(IContactDAO icd) {
		this.icd = icd;
	}

	@Override
	public String getContactList() {
		// TODO Auto-generated method stub
		System.out.println("+++++++调用getContactList方法++++++++++");
		ArrayList<Contact> contactList = new ArrayList<Contact>();
		contactList = (ArrayList<Contact>)icd.findAll();
		String contactList_string = Tools.convert_object_to_string(contactList);
		return contactList_string;
	}

	@Override
	public String changeInfo(String id, String name, String namePinyin, String phone, String mobile,
			String email, String department, String nickname, String address, String note) {
		// TODO Auto-generated method stub
		System.out.println("++++++调用changeInfo方法++++++");
		
		Contact contact = icd.findById(Integer.parseInt(id));
		contact.setName(name);
		contact.setNamePinyin(namePinyin);
		contact.setPhone(phone);
		contact.setMobile(mobile);
		contact.setEmail(email);
		contact.setDepartment(department);
		contact.setNickname(nickname);
		contact.setAddress(address);
		contact.setNote(note);
		
		System.out.println(contact.getPhone());
		icd.update(contact);
		
		HashMap<String,Object> ret = new HashMap<String,Object>();
		
		ret.put("status", 0);
		ret.put("msg", "保存成功");
		
		String ret_string = Tools.convert_object_to_string(ret);
		
		return ret_string;
	}
}
