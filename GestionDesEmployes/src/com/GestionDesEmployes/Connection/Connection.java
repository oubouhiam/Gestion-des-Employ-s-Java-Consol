package com.GestionDesEmployes.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection {
	
	private java.sql.Connection conn;
	private Statement stat;
	private ResultSet rs;
	
	public void Connect() {
		try {
			setConn(DriverManager.getConnection("jdbc:mysql://localhost/gestion_personnel", "root" , ""));
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	public java.sql.Connection getConn() {
		return conn;
	}

	public void setConn(java.sql.Connection conn) {
		this.conn = conn;
	}

	public Statement getStat() {
		return stat;
	}

	public void setStat(Statement stat) {
		this.stat = stat;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

}
