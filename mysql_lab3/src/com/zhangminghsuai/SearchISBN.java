package com.zhangminghsuai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

/**
 * CreateDate：2017-6-4上午12:19:51
 * Location：HIT
 * Author: Zhang Mingshuai
 * TODO
 * return
 */
public class SearchISBN {

	private String isbn;
	private String title;
	private String author;
	private String pr;
	private String pd;
	private String price;
	private String house;
	private String count;
	private String room;
	private String floor;

	
	private String Aid;
	private String Aname;
	private String Aage;
	private String Acountry;
	/**
	 * 
	 */
	public SearchISBN(String isbn) {
		// TODO Auto-generated constructor stub
		this.isbn = isbn;
	}
	
	public String goSearch(DefaultTableModel table) {
		Connection con = GetConnection.get();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from book where isbn = ?");
			stmt.setString(1, isbn);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				title = rs.getString(2);
				author = Aid = rs.getString(3);
				pr =rs.getString(4);
				pd = rs.getString(5);
				price = rs.getString(6);
				
				PreparedStatement Stmt2 = con.prepareStatement("select * from author where authorid = ?");
				Stmt2.setString(1, Aid);
				ResultSet rs2 = Stmt2.executeQuery();
				while(rs2.next()){
					Aname = rs2.getString(2);
					Aage = rs2.getString(3);
					Acountry = rs2.getString(4);
				}
				
				PreparedStatement Stmt3 = con.prepareStatement("select * from house where isbn = ?");
				Stmt3.setString(1, isbn);
				ResultSet rs3 = Stmt3.executeQuery();
				while(rs3.next()){
					house = rs3.getString(1);
					count = rs3.getString(3);
				}
				
				PreparedStatement Stmt4 = con.prepareStatement("select * from room where isbn = ?");
				Stmt4.setString(1, isbn);
				ResultSet rs4 = Stmt4.executeQuery();
				while(rs4.next()){
					room = rs4.getString(1);
					floor = rs4.getString(3);
				}
				table.addRow(new String[]{isbn,title,Aname,Aage,Acountry,pr,pd,price,house,count,room,floor});
			}
			return "Search Successfully";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Search failed!";
		}
		
		
	}
}
