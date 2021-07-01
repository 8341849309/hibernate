package com.nt.test;

import java.util.Scanner;

import com.nt.dao.IInhMappingDao;
import com.nt.dao.InhMappingDaoImpl;

public class Test {

	public static void main(String[] args) {

		IInhMappingDao dao = new InhMappingDaoImpl();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter 1.save 2.load");
		int n = sc.nextInt();

		switch (n) {
		case 1: {
			dao.save();
			break;
		}

		case 2:
			dao.load();
		}
		
		sc.close();
	}

}
