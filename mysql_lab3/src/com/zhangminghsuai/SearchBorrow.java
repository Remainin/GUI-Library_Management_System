package com.zhangminghsuai;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;

/**
 * CreateDate：2017-6-3下午11:22:37
 * Location：HIT
 * Author: Zhang Mingshuai
 * TODO
 * return
 */
public class SearchBorrow {
	private String snumber;
	private String sname;
	private String saddr;
	private String isbn;
	private String title;
	private String author;
	private String authorid;
	
	private String begindate;
	private String enddate;
	
	public SearchBorrow(String snumber){
		this.snumber=snumber;
	}
	public String goSearch(DefaultTableModel tableModel){
		Connection con = GetConnection.get();
		try {
			PreparedStatement stmt1 = con.prepareStatement("select * from borrow where snumber = ?");
			stmt1.setString(1, snumber);
			ResultSet rs1 = stmt1.executeQuery();
			while(rs1.next()){
				isbn = rs1.getString(2);
				begindate = rs1.getString(4);
				enddate = rs1.getString(5);
				PreparedStatement stmt2 = con.prepareStatement("select * from student where snumber = ?");
				stmt2.setString(1, snumber);
				ResultSet rs2 = stmt2.executeQuery();
				while(rs2.next()){
					sname = rs2.getString(2);
					saddr = rs2.getString(3);
				}
				PreparedStatement stmt3 = con.prepareStatement("select title,authorid from book where isbn = ?");
				stmt3.setString(1, isbn);
				ResultSet rs3 = stmt3.executeQuery();
				while(rs3.next()){
					title = rs3.getString(1);
					authorid = rs3.getString(2);
					PreparedStatement stmt4 = con.prepareStatement("select name from author where authorid = ?");
					stmt4.setString(1, authorid);
					ResultSet rs4 = stmt4.executeQuery();
					while(rs4.next()){
						author = rs4.getString(1);
					}
				}
				tableModel.addRow(new String[]{snumber,sname,saddr,title,author,begindate,enddate});
			}
			return "Search Successfully!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Search failed!";
		}
		
	}
}
