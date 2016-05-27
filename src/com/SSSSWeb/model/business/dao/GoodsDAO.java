package com.SSSSWeb.model.business.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.SSSSWeb.model.domain.GOODS_INF;
import com.SSSSWeb.model.domain.GoodsDetial;

public class GoodsDAO {
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public ArrayList<GoodsDetial> SelectGoods(String chn_name, int remark) {
		Session session = sf.openSession();
		StringBuffer sb = new StringBuffer(
				"select g.id,g.code,g.chn_name,g.eng_name,g.type,g.color,g.standard,g.displacement,g.place,g.brand,g.provider,g.price,g.text,c.url,s.quantity,sa.num "
						+ " from  GOODS_INF g inner join CAR_IMG_INF c on g.id=c.goods_id inner join STOCK_INF s on g.id=s.goods_id inner join sale sa on g.id=sa.goods_id  "
						+ " where (g.chn_name like '%"
						+ chn_name
						+ "%' or eng_name like '%"
						+ chn_name
						+ "%' or code like '%"
						+ chn_name
						+ "%') "
						+ " and c.level=1 ");
		if (remark == 1) {
			sb.append(" order by g.price desc ");
		}
		if (remark == 2) {
			sb.append(" order by g.price asc ");
		}
		if (remark == 3) {
			sb.append(" order by sa.num desc ");
		}
		if (remark == 4) {
			sb.append(" order by sa.num asc ");
		}
		Query query = session.createSQLQuery(sb.toString());
		ArrayList resultList = (ArrayList) query.list();
		session.close();
		return resultList;
	}

	public ArrayList<GoodsDetial> SelectDetialGoods(int id) {
		Session session = sf.openSession();
		String hql = "select distinct g.id,g.code,g.chn_name,g.eng_name,g.type,g.color,g.standard,g.displacement,g.place,g.brand,g.provider,g.price,g.text,c.url,s.quantity,sa.num"
				+ " from GOODS_INF g inner join CAR_IMG_INF c on g.id=c.goods_id inner join STOCK_INF s on g.id=s.goods_id inner join sale sa on g.id=sa.goods_id  "
				+ " where g.id =" + id;

		Query query = session.createSQLQuery(hql);
		ArrayList resultList = (ArrayList) query.list();
		session.close();
		return resultList;
	}
}
