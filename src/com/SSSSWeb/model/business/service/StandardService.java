package com.SSSSWeb.model.business.service;

import java.util.ArrayList;

import com.SSSSWeb.model.business.dao.StandardDAO;
import com.SSSSWeb.model.domain.AC_STANDARD_INF;
import com.SSSSWeb.model.domain.GoodsDetial;

public class StandardService {
	private StandardDAO standardDAO;

	public StandardDAO getStandardDAO() {
		return standardDAO;
	}

	public void setStandardDAO(StandardDAO standardDAO) {
		this.standardDAO = standardDAO;
	}
	
	public ArrayList<AC_STANDARD_INF> getAll(){
		ArrayList list = standardDAO.getAllStandard();
		ArrayList<AC_STANDARD_INF> reslist = new ArrayList<AC_STANDARD_INF>();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			AC_STANDARD_INF st = new AC_STANDARD_INF();
			st.setID(Integer.parseInt(obj[0].toString()));
			st.setStandard(obj[1].toString());
			reslist.add(st);
		}
		return reslist;
	}

}
