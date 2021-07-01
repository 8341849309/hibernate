package com.nt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Student;
import com.nt.utils.HibernateUtils;

public class StudentDAOImpl implements IStudentDAO {

	@Override
	public void save() {
		Transaction tx = null;

		try (Session ses = HibernateUtils.getSession()) {

			System.out.println(ses.hashCode());
			
			tx=ses.beginTransaction();
			
			List<String> friends=List.of("Sunil","Vishnu","Shiva","Manju");
			Student st=new Student("Venkateswalu", "Love", friends);
			
			ses.save(st);
			tx.commit();
			System.out.println("Student is saved!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("Problem in saving...");
		}

	}

	@Override
	public void load() {
		
		try(Session ses=HibernateUtils.getSession()){
			
			Transaction tx=ses.beginTransaction();
			
			System.out.println(ses.hashCode());
			
			Query query=ses.createQuery("from Student");
			List<Student> list=query.getResultList();
			
			list.forEach(st->{
				System.out.println("Sis:: "+st.getSid()+" Sname:: "+st.getSname()+" Course:: "+st.getCourse());
				
				List<String> friends=st.getFriends();
				
				friends.forEach(System.out::println);
				
			});
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
