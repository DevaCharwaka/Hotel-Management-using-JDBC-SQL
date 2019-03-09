package com.hotel.ui;

import java.util.Scanner;

import com.hotel.beans.Customer;
import com.hotel.service.CustomerService;
import com.hotel.service.CustomerServiceImpl;

public class View {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		CustomerService service=new CustomerServiceImpl();
		
	//	Customer cust = new Customer();
		
		while(true) {
			System.out.println("Enter \n1) book room \n2) view booking status \n3) exit");
			int choice=sc.nextInt();
			switch(choice) {
			case 1: service.getRoomBooking();
		//			System.out.println("your id is "+custo.getEmail());
					break;
			case 2:service.viewStatus();
			 		break;
			case 3:System.exit(0);
					break;
			}
			}
			}
		}




