package com.zhangminghsuai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

/**
 * CreateDate：2017-6-3下午11:12:18
 * Location：HIT
 * Author: Zhang Mingshuai
 * TODO
 * return
 */
public class Borrow {
	
	private String snumber;
	private String isbn;
	private String day;
	private String begindate;
	private String enddate;
	
	public Borrow(String snumber,String isbn,String day,String begindate,String enddate){
		this.snumber = snumber;
		this.isbn = isbn;
		this.day = day;
		this.begindate = begindate;
		this.enddate = enddate;
	}
	
	public String goBorrow() {
		Connection con = GetConnection.get();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into borrow"+" values(?,?,?,?,?)");
			stmt.setString(1, snumber);
			stmt.setString(2, isbn);
			stmt.setString(3, day);
			stmt.setString(4, begindate);
			stmt.setString(5, enddate);
			stmt.executeUpdate();
			PreparedStatement stmt2 = con.prepareStatement("select count from house where isbn = ?");
			stmt2.setString(1, isbn);
			ResultSet rs = stmt2.executeQuery();
			String countString = new String();
			while(rs.next()){
				countString = rs.getString(1);
				countString = String.valueOf(Integer.valueOf(countString)-1);
				PreparedStatement stmt3 = con.prepareStatement("update house set count=? where isbn=?");
				stmt3.setString(1, countString);
				stmt3.setString(2, isbn);
				stmt3.executeUpdate();
			}
			return "borrow successfully!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "borrow failed!";
		}
		
	}
}
