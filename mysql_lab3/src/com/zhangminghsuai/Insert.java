package com.zhangminghsuai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * CreateDate：2017-6-3下午08:04:24
 * Location：HIT
 * Author: Zhang Mingshuai
 * TODO
 * return
 */
public class Insert {

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
	
	private String snumber;
	private String sname;
	private String saddr;
	
	private String Aid;
	private String Aname;
	private String Aage;
	private String Acountry;

	public Insert(String isbn,String title,String author,
			String pr,String pd,String price,String house,
			String count,String room,String floor){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.pr = pr;
		this.pd = pd;
		this.price = price;
		this.house = house;
		this.count = count;
		this.room = room;
		this.floor = floor;
	}
	
	public Insert(String snumber,String sname,String saddr){
		this.snumber = snumber;
		this.sname = sname;
		this.saddr = saddr;
	}
	
	public Insert(String Aid,String Aname,String Aage,String Acountry){
		this.Aid = Aid;
		this.Aname = Aname;
		this.Aage = Aage;
		this.Acountry = Acountry;
	}
	
	public String goBook(){
		Connection con = GetConnection.get();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into book"+" values(?,?,?,?,?,?)");
			stmt.setString(1,isbn);
			stmt.setString(2,title);
			stmt.setString(3,author);
			stmt.setString(4,pr);
			stmt.setString(5,pd);
			stmt.setString(6,price);
			PreparedStatement stmt1 = con.prepareStatement("insert into house"+" values(?,?,?)");
			stmt1.setString(1,house);
			stmt1.setString(2,isbn);
			stmt1.setString(3,count);
			PreparedStatement stmt2 = con.prepareStatement("insert into room"+" values(?,?,?)");
			stmt2.setString(1,room);
			stmt2.setString(2,isbn);
			stmt2.setString(3,floor);
			stmt.executeUpdate();
			stmt1.executeUpdate();
			stmt2.executeUpdate();
			return "Success Insert!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Fail";
		}
	}
	
	public String goStudent(){
		Connection con = GetConnection.get();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into student"+" values(?,?,?)");
			stmt.setString(1,snumber);
			stmt.setString(2,sname);
			stmt.setString(3,saddr);
			stmt.executeUpdate();
			return "Success Insert!";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Fail";
		}
	}
	
	public String goAuthor(){
		Connection con = GetConnection.get();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into author"+" values(?,?,?,?)");
			stmt.setString(1,Aid);
			stmt.setString(2,Aname);
			stmt.setString(3,Aage);
			stmt.setString(4,Acountry);
			stmt.executeUpdate();
			return "Success Insert!";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Fail";
		}
	}
}
