package com.nt.test;

import com.nt.dao.ITravellerDAO;
import com.nt.dao.TravellerDAOImpl;

public class Test {

	public static void main(String[] args) {

		ITravellerDAO dao = new TravellerDAOImpl();

		//dao.save();

		dao.load();

	}

}
