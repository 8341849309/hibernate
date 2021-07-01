package com.nt.test;

import com.nt.dao.IInhMappingDao;
import com.nt.dao.InhMappingDaoImpl;

public class Test {

	public static void main(String[] args) {
		
		IInhMappingDao dao=new InhMappingDaoImpl();
		
		//dao.save();
		
		dao.load();
		
	}

}
