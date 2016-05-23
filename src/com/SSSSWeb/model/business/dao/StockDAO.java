package com.SSSSWeb.model.business.dao;

import java.util.ArrayList;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.SSSSWeb.model.domain.Indent;
import com.SSSSWeb.model.domain.STOCK_INF;

public class StockDAO {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public STOCK_INF getStockByGoodsId(int id){
		Session session = sf.openSession();
		String hql = "select * from STOCK_INF where goods_id="+id;
		Query query = session.createSQLQuery(hql);
		ArrayList list = (ArrayList) query.list();
		Object[] obj = (Object[]) list.get(0);
		STOCK_INF stock = new STOCK_INF();
		stock.setId(Integer.parseInt(obj[0].toString()));
		stock.setGoods_id(Integer.parseInt(obj[1].toString()));
		stock.setQuantity(Integer.parseInt(obj[2].toString()));
		return stock;
	}
	
	public void updateStock(STOCK_INF stock){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		STOCK_INF old_stock = (STOCK_INF) session.get(STOCK_INF.class, stock.getId());
        old_stock.setGoods_id(stock.getGoods_id());
        old_stock.setQuantity(stock.getQuantity());
        session.save(old_stock);
        tx.commit();
        session.close();
	}
	
	public void deleteStock(int ID){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction(); 
		STOCK_INF stock = (STOCK_INF) session.get(STOCK_INF.class, ID);
		session.delete(stock);
		tx.commit();
		session.close();
	}
	
	public void insertStock(STOCK_INF stock){
		Session session = sf.openSession();
        session.save(stock);
        session.close();
	}

}
