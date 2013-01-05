package cn.edu.nju.software.dao;

import java.util.List;
import cn.edu.nju.software.model.Contact;
import cn.edu.nju.software.model.User;
public interface IContactDAO {
	public List<Contact> findAll();
	public Contact findById(Integer id); 
	public void update(Contact cnt);
}
