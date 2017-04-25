package com.zhangminghsuai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * CreateDate：2017-6-3下午10:17:11
 * Location：HIT
 * Author: Zhang Mingshuai
 * TODO
 * return
 */
public class Update {
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
	
	public Update(String isbn,String title,String author,
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
	
	public Update(String snumber,String sname,String saddr){
		this.snumber = snumber;
		this.sname = sname;
		this.saddr = saddr;
	}
	
	public Update(String Aid,String Aname,String Aage,String Acountry){
		this.Aid = Aid;
		this.Aname = Aname;
		this.Aage = Aage;
		this.Acountry = Acountry;
	}
	
	public String goBook(){
		Connection con = GetConnection.get();
		try {
			PreparedStatement stmt = con.prepareStatement("update book set Title = ?,AuthorID = ?,Publisher = ?, PublishDate = ?, Price = ?"+" where ISBN = ?");
			stmt.setString(6,isbn);
			stmt.setString(1,title);
			stmt.setString(2,author);
			stmt.setString(3,pr);
			stmt.setString(4,pd);
			stmt.setString(5,price);
			PreparedStatement stmt1 = con.prepareStatement("update house set hnumber = ?,count = ? where isbn = ?");
			stmt1.setString(1,house);
			stmt1.setString(3,isbn);
			stmt1.setString(2,count);
			PreparedStatement stmt2 = con.prepareStatement("update room set rnumber = ?,floor = ? where isbn = ?");
			stmt2.setString(1,room);
			stmt2.setString(3,isbn);
			stmt2.setString(2,floor);
			stmt.executeUpdate();
			stmt1.executeUpdate();
			stmt2.executeUpdate();
			return "Success Update!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Fail";
		}
	}
	
	public String goStudent(){
		Connection con = GetConnection.get();
		try {
			PreparedStatement stmt = con.prepareStatement("update student set sname = ?,saddr = ? where snumber = ?");
			stmt.setString(3,snumber);
			stmt.setString(1,sname);
			stmt.setString(2,saddr);
			stmt.executeUpdate();
			return "Success Update!";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Fail";
		}
	}
	
	public String goAuthor(){
		Connection con = GetConnection.get();
		try {
			PreparedStatement stmt = con.prepareStatement("update author set name = ?,age = ?,country = ? where authorid = ?");
			stmt.setString(4,Aid);
			stmt.setString(1,Aname);
			stmt.setString(2,Aage);
			stmt.setString(3,Acountry);
			stmt.executeUpdate();
			return "Success Update!";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Fail";
		}
	}
}
