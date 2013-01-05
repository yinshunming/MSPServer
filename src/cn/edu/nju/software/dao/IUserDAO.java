package cn.edu.nju.software.dao;

import java.util.List;

import cn.edu.nju.software.model.User;

public interface IUserDAO {
	public List<User> findByUsername(Object username);
}
