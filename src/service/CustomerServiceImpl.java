package com.hotel.service;

import com.hotel.beans.Customer;
import com.hotel.dao.CustomerDao;
import com.hotel.dao.CustomerDaoImpl;
import com.hotel.utility.*;

public class CustomerServiceImpl implements CustomerService{

	CustomerDao custdao=new CustomerDaoImpl();


	public void getRoomBooking() {
		try {
			custdao.getRoomBooking();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void viewStatus() throws Exception {
		custdao.getviewStatus();
		
	}

}
