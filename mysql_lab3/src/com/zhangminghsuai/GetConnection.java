package com.zhangminghsuai;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * CreateDate：2017-6-3下午08:13:52
 * Location：HIT
 * Author: Zhang Mingshuai
 * TODO
 * return
 */
public class GetConnection {
	static Connection connect;
	public static Connection get() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "1234");
			System.out.println("Success connect Mysql server!");
		} catch (Exception e) {
			System.out.print("get data error!");
			e.printStackTrace();
		}
		return connect;
	}
}