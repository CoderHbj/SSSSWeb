package com.SSSSWeb.model.business.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StandardDAO {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public ArrayList getAllStandard() {
		Session session = sf.openSession();
		String hql = "select * from AC_STANDARD_INF";
		Query query = session.createSQLQuery(hql);
		ArrayList resultList = (ArrayList) query.list();
		session.close();
		return resultList;
	}
}
