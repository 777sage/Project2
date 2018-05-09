package com.revature.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.revature.model.Test;
import com.revature.util.HibernateUtil;

public class TestDaoImpl implements TestDao {

	public void insertTest(Test tst) {
		Session session = HibernateUtil.getSession().openSession();
		Transaction t1 = null;
		try {
			t1 = session.beginTransaction();
			session.save(tst);
			t1.commit();

		} catch (HibernateException h) {
			if (t1 != null) {
				t1.rollback();
			}
		} finally {
			session.close();
		}

	}

	public void updateTest(String name, String status) {
		Session session = HibernateUtil.getSession().openSession();
		Transaction t1 = null;
		Test tst;
		try {
			t1 = session.beginTransaction();
			Query query = session.createQuery("FROM Test WHERE testName=:name");
			query.setParameter("name", name);
			tst = (Test) query.getSingleResult();
			tst.setStatus(status);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			tst.setTimestamp(timestamp);
			session.saveOrUpdate(tst);
			t1.commit();
		} catch(NoResultException n) {
			tst=new Test(name,status);
			session.save(tst);
			t1.commit();
		}
		catch (HibernateException h) {
			if (t1 != null) {
				t1.rollback();
			}
		} finally {
			session.close();
		}
	}

	public Test findTestByName(String name) {
		Session session = HibernateUtil.getSession().openSession();
		Test tst = null;
		try {
			session.beginTransaction();
			Query query = session.createQuery("FROM Test WHERE testName=:name");
			query.setParameter("name", name);
			tst = (Test) query.getSingleResult();
		} catch (HibernateException h) {
			//
		} finally {
			session.close();
		}
		return tst;
	}

	@SuppressWarnings("unchecked")
	public List<Test> getAllTests() {
		Session session = HibernateUtil.getSession().openSession();
		List<Test> Tests = null;
		try {
			session.beginTransaction();
			Tests = session.createQuery("from com.revature.model.Test").list();
		} catch (HibernateException h) {
			//
		} finally {
			session.close();
		}
		return Tests;
	}

	public void deleteTest(int id) {
		// TODO Auto-generated method stub

	}
}