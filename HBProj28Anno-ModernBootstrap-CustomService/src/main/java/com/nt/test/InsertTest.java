package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PgmrProjId;
import com.nt.entity.Programmer_Project;
import com.nt.utils.HibernateUtils;

public class InsertTest {

	public static void main(String[] args) {

		Transaction tx = null;

		try (Session ses = HibernateUtils.getSession()) {

			tx = ses.beginTransaction();

			PgmrProjId id = new PgmrProjId();
			id.setPgmrId(846739);
			id.setProjId(1239);

			Programmer_Project proj = new Programmer_Project();
			proj.setId(id);
			proj.setPgmrName("Rama");
			proj.setAge(23);
			proj.setProjName("CBD-CCP Prod Eng");

			PgmrProjId idVal = (PgmrProjId) ses.save(proj);

			tx.commit();
			System.out.println("Object is saved " + idVal);

		} catch (HibernateException he) {
			he.printStackTrace();
			System.out.println("Object is not saved");
			tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Object is not saved");
			tx.rollback();
		}

	}

}
