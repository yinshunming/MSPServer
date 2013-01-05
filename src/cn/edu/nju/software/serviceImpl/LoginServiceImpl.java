package cn.edu.nju.software.serviceImpl;

import java.util.HashMap;
import java.util.List;

import cn.edu.nju.software.dao.IUserDAO;
import cn.edu.nju.software.model.User;
import cn.edu.nju.software.service.ILoginService;
import cn.edu.nju.software.util.Tools;

public class LoginServiceImpl implements ILoginService{
	private IUserDAO iud;
	@Override
	public String login(String username, String password) {
		System.out.println("+++++++调用login方法++++++++++");
		// TODO Auto-generated method stub
		HashMap<String,Object> ret = new HashMap<String,Object>();
		List<User> userList = iud.findByUsername(username);
		if(userList.size() == 0){
			ret.put("status", 1);
			ret.put("msg", "不存在的用户");
			ret.put("User", null);			
		} else {
			User user = userList.get(0);
			System.out.println("user password" + user.getPasswd());
			if(user.getPasswd().equals(password)){
				ret.put("status", 0);
				ret.put("msg","登录成功");
				ret.put("User", user);
			} else {
				ret.put("status", 1);
				ret.put("msg", "错误的密码");
				ret.put("User", null);
			}
		}
		System.out.println("返回值是：" + ret.toString());
		String ret_string = Tools.convert_object_to_string(ret);
		return ret_string;
	}
	
	public IUserDAO getIud() {
		return iud;
	}
	public void setIud(IUserDAO iud) {
		this.iud = iud;
	}

}
