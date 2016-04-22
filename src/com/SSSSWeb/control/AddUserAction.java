/**
 * LY.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.SSSSWeb.control;

import com.SSSSWeb.model.business.service.UsersService;
import com.SSSSWeb.model.domain.Users;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author sy25471
 * @version $Id: InsertUsersAction.java, v 0.1 2016年4月19日 上午11:32:46 sy25471 Exp $
 */
public class AddUserAction extends ActionSupport implements ModelDriven<Users> {
    /**  */
    private static final long serialVersionUID = 4878223622943894007L;
    private Users user = new Users();
    private UsersService service;
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
    public UsersService getService() {
        return service;
    }
    public void setService(UsersService service) {
        this.service = service;
    }
    @Override
    public String execute() throws Exception{
        int i;
        i=service.insertUser(user);
        if(i == 0){
            return "success";
        }
        return "input";
    }
    public Users getModel(){
        return user;
    }
}
