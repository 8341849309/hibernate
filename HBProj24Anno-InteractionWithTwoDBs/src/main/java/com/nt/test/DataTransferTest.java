package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PgmrProjId;
import com.nt.entity.Programmer_Project;
import com.nt.utils.MysqlHibernateUtils;
import com.nt.utils.OracleHibernateUtils;

public class DataTransferTest {

	public static void main(String[] args) {

		Transaction tx = null;

		try (Session oraSes = OracleHibernateUtils.getSession(); Session mysqlSes = MysqlHibernateUtils.getSession()) {

			tx = oraSes.beginTransaction();

			PgmrProjId id = new PgmrProjId();
			id.setPgmrId(846735);
			id.setProjId(1234);

			Programmer_Project proj = mysqlSes.get(Programmer_Project.class, id);
			System.out.println(proj);

			PgmrProjId oraId = null;
			
			if (proj != null) {
				oraId = (PgmrProjId) oraSes.save(proj);
				tx.commit();
			}
			
			System.out.println("Object is transferred:: " + oraId);

		} catch (HibernateException he) {
			he.printStackTrace();
			tx.rollback();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

	}

}
