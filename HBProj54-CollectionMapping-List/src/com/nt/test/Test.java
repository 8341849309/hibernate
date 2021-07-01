package com.nt.test;

import com.nt.dao.IStudentDAO;
import com.nt.dao.StudentDAOImpl;

public class Test {

	public static void main(String[] args) {
		
		IStudentDAO dao=new StudentDAOImpl();
		
		dao.save();
		
		System.out.println("=============================");
		dao.load();
		
	}

}
