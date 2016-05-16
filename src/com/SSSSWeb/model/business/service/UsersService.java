/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.SSSSWeb.model.business.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.SSSSWeb.model.business.dao.UsersDAO;
import com.SSSSWeb.model.domain.Posts;
import com.SSSSWeb.model.domain.Users;

/**
 * 
 * @author sy25471
 * @version $Id: UsersService.java, v 0.1 2016年4月19日 上午11:15:32 sy25471 Exp $
 */
public class UsersService {
    private UsersDAO usersDAO;

    public UsersDAO getUsersDAO() {
        return usersDAO;
    }

    public void setUsersDAO(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }
    
    @Transactional
    public int insertUser(Users user) {
        int i;
        i=usersDAO.insertUser(user);
        return i;
    }
 
    @Transactional
    public void updateUser(Users user) {
        usersDAO.updateUser(user);
    }
    @Transactional
    public Users checkUser(Users user) {
        user=usersDAO.CheckUser(user);
        return user;
    }
    @Transactional
    public void ChangePsw(Users user, String newpassword) {
        usersDAO.ChangePsw(user, newpassword);
        
    }
    @Transactional
    public void DeleteUser(Users user){
        usersDAO.DeleteUser(user);
    }
    @Transactional
    public int PageNum(int pageSize, String value){
        int pageNum = usersDAO.PageNum(pageSize, value);
        return pageNum;
    }
    @Transactional
    public Users FindUserById(int id){
        ArrayList list = usersDAO.findUserById(id);
        Object[] obj = (Object[]) list.get(0);
        Users u = new Users();
        u.setUserid(Integer.valueOf(obj[0].toString()));
        u.setUsername(obj[1].toString());
        u.setPassword(obj[2].toString());
        u.setPhonenum(obj[3].toString());
        u.setUsex(obj[4].toString());
        u.setPost(obj[5].toString());
        return u;
    }
    @Transactional
    public ArrayList<Users> SelectAllUser(int pageSize, int pageNow){
        ArrayList list = usersDAO.selectAllUser(pageSize, pageNow);
        ArrayList resultList = new ArrayList();
        for(int i=0;i<list.size();i++){
            Object[] obj = (Object[]) list.get(i);
            Users u = new Users();
            u.setUserid(Integer.valueOf(obj[0].toString()));
            u.setUsername(obj[1].toString());
            u.setPassword(obj[2].toString());
            u.setPhonenum(obj[3].toString());
            u.setUsex(obj[4].toString());
            u.setPost(obj[5].toString());
            resultList.add(u);
        }
        return resultList;
    }
    @Transactional
    public ArrayList<Users> SelectUser(String key, int pageSize, int pageNow){
        ArrayList list = usersDAO.selectUser(key,pageSize,pageNow);
        ArrayList resultList = new ArrayList();
        for(int i=0;i<list.size();i++){
            Object[] obj = (Object[]) list.get(i);
            Users u = new Users();
            u.setUserid(Integer.valueOf(obj[0].toString()));
            u.setUsername(obj[1].toString());
            u.setPassword(obj[2].toString());
            u.setPhonenum(obj[3].toString());
            u.setUsex(obj[4].toString());
            u.setPost(obj[5].toString());
            resultList.add(u);
        }
        return resultList;
    }
    @Transactional
	public ArrayList<Posts> postList(){
		ArrayList list = usersDAO.postList();
        ArrayList resultList = new ArrayList();
        for(int i=0;i<list.size();i++){
            Object[] obj = (Object[]) list.get(i);
            Posts p = new Posts();
            p.setPostid(Integer.valueOf(obj[0].toString()));
            p.setPost(obj[1].toString());
            p.setTask(obj[2].toString());
            resultList.add(p);
        }
        return resultList;
	}
}
