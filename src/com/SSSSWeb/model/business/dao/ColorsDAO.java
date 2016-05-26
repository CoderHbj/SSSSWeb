package com.SSSSWeb.model.business.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.SSSSWeb.model.domain.Color;
import com.SSSSWeb.model.domain.GoodsDetial;

public class ColorsDAO {

	private static int DONE = 1;
	private static int FAIL = 0;
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public ArrayList<Color> SelectAllColors() {
		Session session = sf.openSession();
		String hql = "select id,color " + "from CAR_COLOR_INF";
		Query query = session.createSQLQuery(hql);
		ArrayList resultList = (ArrayList) query.list();
		session.close();
		return resultList;
	}
}
