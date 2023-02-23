package com.pratiti.app;

import java.time.LocalDate;

import com.pratiti.dao.PersonPassportDao;
import com.pratiti.entity.Passport;
import com.pratiti.entity.Person;

public class PersonApp {
	public static void main(String[] args) {
		
		PersonPassportDao personDao=new PersonPassportDao();
		
//		Person p=new Person();
//		p.setName("kartik");
//		p.setAge(18);
//		
		Person pp=personDao.fetchPerson(14);
		Passport passport=new Passport();
		passport.setIssuedDate(LocalDate.of(2020, 2, 23));
		passport.setExpiryDate(LocalDate.of(2023, 3, 23));
		passport.setPerson(pp);
		personDao.add(passport);
	}

}
