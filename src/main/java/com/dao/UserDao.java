package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.User;
import com.util.DbUtil;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
		System.out.println(connection);
	}

	public String deleteUser(int userId) {
		String stat = " Delete success";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from crud where rollno=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stat;
	}

	public void addUser(User user) {

		// new UserDao();
		System.out.println("The connecton----" + connection);
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into crud(name,rollno,lastname) values ( ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getRollno());
			preparedStatement.setString(3, user.getLname());
			preparedStatement.executeUpdate();

			System.out.println("Add sucess");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<User> getAllUsers() {
		new UserDao();

		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from crud");
			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setRollno(rs.getInt("rollno"));
				user.setLname(rs.getString("lastname"));
				users.add(user);
				System.out.println("Add users------------" + users);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User getUserById(int rollno) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from crud where rollno=?");
			preparedStatement.setInt(1, rollno);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user.setRollno(rs.getInt("rollno"));
				user.setName(rs.getString("name"));
				user.setLname(rs.getString("lastname"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@SuppressWarnings("unused")
	public String updateUser(User user) {
		System.out.println(user.getRollno());
		String stat = "Success";
		String stats = "Failure";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update crud set name=?, lastname=? where rollno=?");

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLname());
			preparedStatement.setInt(3, user.getRollno());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stat;

	}

}