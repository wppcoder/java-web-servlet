package com.wpp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.wpp.model.User;

public class UserDaoImpl implements UserDao{

	@Override
	public void save(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		String saveSql = "insert into t_user(username,description) values(?,?)";
		PreparedStatement ps = conn.prepareCall(saveSql); 
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getDescription());
		ps.execute();
	}

	@Override
	public User getUser(Connection conn, String userName) throws SQLException {
		// TODO Auto-generated method stub
		String selectSql = "select * from t_user where username = ?";
		PreparedStatement ps = conn.prepareStatement(selectSql);
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		User user = new User();
		while(rs.next()){
			user.setUsername(rs.getString("userName"));
			user.setDescription(rs.getString("description"));
		}
		return user;
	}

}
