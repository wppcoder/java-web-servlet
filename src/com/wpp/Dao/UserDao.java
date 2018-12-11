package com.wpp.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.wpp.model.User;


public interface UserDao {

	public void save(Connection conn,User user) throws SQLException;
	
	public User getUser(Connection conn,String userName)throws SQLException;
}
