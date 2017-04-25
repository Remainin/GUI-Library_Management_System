package com.zhangminghsuai;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

/**
 * CreateDate：2017-6-3下午10:53:38
 * Location：HIT
 * Author: Zhang Mingshuai
 * TODO
 * return
 */
public class Delete {
	
	private String isbn;
	private String authorid;
	private String snumber;
	
	
	public String goBook(String isbn1){
		this.isbn = isbn1;
		Connection con = GetConnection.get();
		java.sql.PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("delete from book where isbn = ?");
			stmt.setString(1, isbn);
			stmt.executeUpdate();
			return "delete Successfully!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "delete failed!";
		}
	}
	
	public String goAuthor(String author){
		this.authorid = author;
		Connection con = GetConnection.get();
		java.sql.PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("delete from author where authorid = ?");
			stmt.setString(1, authorid);
			stmt.executeUpdate();
			return "delete Successfully!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "delete failed!";
		}
	}
	
	public String goStudent(String number){
		this.snumber = number;
		Connection con = GetConnection.get();
		java.sql.PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("delete from student where snumber = ?");
			stmt.setString(1, snumber);
			stmt.executeUpdate();
			return "delete Successfully!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "delete failed!";
		}
	}
}
