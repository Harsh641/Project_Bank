package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.BankBean;
import com.util.DbConnection;

public class BankDao {
	public static ArrayList<BankBean> users = new ArrayList<BankBean>();
	
	public void insertUpdate(BankBean bank) {
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into bank(first_name, last_name, email, password) values (?, ?, ?, ?)");){
			pstmt.setString(1, bank.getFirstName());
			pstmt.setString(2, bank.getLastName());
			pstmt.setString(3, bank.getEmail());
			pstmt.setString(4, bank.getPassword());
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<BankBean> getAllUsers(){
		ArrayList<BankBean> users = new ArrayList<BankBean>();
		try(Connection con =  DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from bank");){
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BankBean bb = new BankBean();
				bb.setAcc_no(rs.getInt("acc_no"));
				bb.setFirstName(rs.getString("first_name"));
				bb.setLastName(rs.getString("last_name"));
				bb.setEmail(rs.getString("email"));
				bb.setPassword(rs.getString("password"));
				users.add(bb);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public BankBean authenticate(String email, String password) {
		for(BankBean user:users) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}
