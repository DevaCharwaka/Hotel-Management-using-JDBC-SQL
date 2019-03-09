package com.hotel.dao;

import java.sql.*;
import java.util.Scanner;

import com.hotel.utility.*;

import com.hotel.beans.Customer;
public class CustomerDaoImpl implements CustomerDao  {
	Scanner sc = new Scanner(System.in);

	Database db = new Database();
	Connection con=db.getConnection();
	Customer cust = new Customer();

	public void getRoomBooking() throws Exception {
		
		PreparedStatement pst = con.prepareStatement("insert into CustomerDetails(custName,email,custAddress,mobileNo,RoomType,RoomNo) values(?,?,?,?,?,?)");
		System.out.println("enter name");
			String str1 = sc.next();
			pst.setString(1,str1);

			System.out.println("enter email");
			String str2 = sc.next();
			pst.setString(2,str2);

			System.out.println("enter address");

			String str3  = sc.next();
			pst.setString(3,str3);
			
			System.out.println("enter mobile no");
			long l1 = sc.nextLong();
			pst.setLong(4,l1);

			System.out.println("enter room type");
			String str4 = sc.next();
			pst.setString(5,str4);

			System.out.println("enter room number");

			int i1 = sc.nextInt();
			pst.setInt(6,i1);

			// System.out.println(" he "+cust.getName());
			
			int rs = pst.executeUpdate();
	

	if(rs==1) {
		PreparedStatement pst1=con.prepareStatement("Select CustID from CustomerDetails where RoomNo="+"?");
		pst1.setInt(1, i1);
		PreparedStatement pst2=con.prepareStatement("update RoomDetails set status='Booked' where RoomNo="+"?");
		pst2.setInt(1, i1);
		pst2.executeUpdate();
		ResultSet rs1=pst1.executeQuery();
		rs1.next();
		System.out.println("Your Room has been successfully booked. Your CustomerID is :"+rs1.getInt(1));
		
	}

	}
	public void getviewStatus() throws Exception {
		System.out.println("Enter the customer id");
		int id2 =sc.nextInt(); 
		PreparedStatement pst2=con.prepareStatement("Select * from CustomerDetails  where CustId="+"?");
		pst2.setInt(1,id2);
		PreparedStatement pst3=con.prepareStatement("Select status from RoomDetails r,customerdetails c where (r.roomno=c.roomno) and custid="+"?");
		pst3.setInt(1,id2);
		ResultSet rs3=pst3.executeQuery();
		ResultSet rs2=pst2.executeQuery();
		while(rs2.next()) {
			if(rs2.getInt(1)==id2) {
			System.out.println("Name of the customer "+rs2.getString("custName"));
		//	System.out.println("booking status "+rs2.getString("status"));
			System.out.println("Room number "+rs2.getInt("RoomNo"));
			System.out.println("Room type "+rs2.getString("RoomType"));
		}
			rs3.next();
			System.out.println("booking status "+rs3.getString("status"));
	}
		
	}
}
