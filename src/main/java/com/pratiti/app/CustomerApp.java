package com.pratiti.app;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaDescriptor;

import com.pratiti.dao.CustomerAddressDao;
import com.pratiti.entity.Address;
import com.pratiti.entity.Customer;
import com.pratiti.entity.Employee;

public class CustomerApp {
	public static void main(String[] args) {
		
		CustomerAddressDao dao=new CustomerAddressDao();
		
//		
//		Customer cust =new Customer();
//		cust.setName("sarthak");
//		cust.setEmail("sarthak@gmail.com");
//		cust.setDateOfBirth(LocalDate.of(2002,8,2));
		
//		customerDao.add(cust);
		
//		Customer customer=dao.fetchCustomer(10);
//		Address adr=new Address();
//		adr.setLine1("mg road");
//		adr.setLine2("Mumbai naka");
//		adr.setPincode(411045);
//		adr.setCity("Nashik");
//		customer.setAddress(adr);
//		dao.update(customer);
//		
		//fetch customer by city
		
//		List<Customer> list=dao.fetchCustomerByCity("Pune");
//		for(Customer cut:list) {
//			System.out.println(cut.getName()+" "+cut.getId());
//		}
		
		List<Object[]> list=dao.fetchCustomerInfo("Pune");
		for(Object[] it:list) {
			
			String name=(String)it[0];
			System.out.println(it[0]+" "+it[1]+" "+it[2]);
		}
		
		
	}
}
