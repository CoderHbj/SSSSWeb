package com.SSSSWeb.model.business.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.SSSSWeb.model.domain.Indent;

public class IndentDAO {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public ArrayList getUncheckedSubList(){
		Session session = sf.openSession();
		String hql = "select i.id,g.code,g.chn_name,g.eng_name,s.supplier_name,i.quantity "
				+ "from Indent i,GOODS_INF g,Supplier s "
				+ "where i.status='unchecked' "
				+ "and i.goods_id=g.id "
				+ "and s.supplier_id=g.provider;";
		Query query = session.createSQLQuery(hql);
		ArrayList resultList = (ArrayList) query.list();
		session.close();
		return resultList;
	}
	
	public void checkSubList(int id){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Indent indent = (Indent) session.get(Indent.class, id);
		indent.setCheck_time(datetime);
		indent.setStatus("checked");
		session.save(indent);
		tx.commit();
		session.close();
	}
	
	public void addIndent(Indent indent){
		Session session = sf.openSession();
		session.save(indent);
		session.close();
	}
	
	public Indent getIndentById(int id){
		Session session = sf.openSession();
		Indent indent = (Indent) session.get(Indent.class, id);
		session.close();
		return indent;
	}
}
