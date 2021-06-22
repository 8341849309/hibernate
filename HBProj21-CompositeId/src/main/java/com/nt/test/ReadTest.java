package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.PgmrProjId;
import com.nt.entity.Programmer_Project;
import com.nt.utils.HibernateUtils;

public class ReadTest {

	public static void main(String[] args) {

		try (Session ses = HibernateUtils.getSession()) {

			PgmrProjId id = new PgmrProjId();
			id.setPgmrId(846736);
			id.setProjId(1234);

			Programmer_Project proj = ses.get(Programmer_Project.class, id);

			System.out.println("Record found " + proj);

		} catch (HibernateException he) {
			he.printStackTrace();
			System.out.println("Record is not found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Record is not found");
		}

	}

}
