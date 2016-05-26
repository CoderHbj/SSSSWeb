package com.SSSSWeb.model.business.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.SSSSWeb.model.business.dao.ColorsDAO;
import com.SSSSWeb.model.domain.Color;
import com.SSSSWeb.model.domain.GoodsDetial;

public class ColorsService {
	private ColorsDAO colorsDAO;

	public ColorsDAO getColorsDAO() {
		return colorsDAO;
	}

	public void setColorsDAO(ColorsDAO colorsDAO) {
		this.colorsDAO = colorsDAO;
	}

	// 查询所有颜色
	@Transactional
	public ArrayList<Color> SelectAllColor() {
		ArrayList su = colorsDAO.SelectAllColors();
		ArrayList colorlist = new ArrayList();
		for (int i = 0; i < su.size(); i++) {
			Object[] obj = (Object[]) su.get(i);
			Color to = new Color();
			to.setID(Integer.valueOf(obj[0].toString()));
			to.setColor(obj[1].toString());
			colorlist.add(to);
		}
		return colorlist;
	}
}