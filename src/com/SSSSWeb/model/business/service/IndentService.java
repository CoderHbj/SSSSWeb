package com.SSSSWeb.model.business.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.SSSSWeb.model.business.dao.IndentDAO;
import com.SSSSWeb.model.business.dao.StockDAO;
import com.SSSSWeb.model.domain.Indent;
import com.SSSSWeb.model.domain.STOCK_INF;
import com.SSSSWeb.model.domain.UncheckedSubList;

public class IndentService {
	private IndentDAO indentDAO;
	private StockDAO stockDAO;

	public IndentDAO getIndentDAO() {
		return indentDAO;
	}

	public void setIndentDAO(IndentDAO indentDAO) {
		this.indentDAO = indentDAO;
	}
	
	public StockDAO getStockDAO() {
		return stockDAO;
	}

	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	//获取未签收订货单
	@Transactional
	public ArrayList<UncheckedSubList> getUncheckedSubList(){
		ArrayList list = indentDAO.getUncheckedSubList();
		ArrayList resultlist = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			UncheckedSubList sublist = new UncheckedSubList();
			sublist.setId(Integer.parseInt(obj[0].toString()));
			sublist.setCode(obj[1].toString());
			sublist.setChn_name(obj[2].toString());
			sublist.setEng_name(obj[3].toString());
			sublist.setSupplier_name(obj[4].toString());
			sublist.setQuantity(Integer.parseInt(obj[5].toString()));
			resultlist.add(sublist);
		}
		return resultlist;
	}
	
	//签收订货单
	@Transactional
	public void check(int id){
		Indent indent = indentDAO.getIndentById(id);
		int add_quantity = indent.getQuantity();
		STOCK_INF stock = stockDAO.getStockByGoodsId(indent.getGoods_id());
		stock.setQuantity(stock.getQuantity()+add_quantity);
		stockDAO.updateStock(stock);
		indentDAO.checkSubList(id);
	}
	
	//填写订货单
	@Transactional
	public void add(Indent indent){
		String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		indent.setSubmit_time(datetime);
		indent.setStatus("unchecked");
		indentDAO.addIndent(indent);
	}
}
