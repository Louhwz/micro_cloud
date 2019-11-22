package com.louhwz.register.entity;

/**
 * 插入数据库的User类对象，是对类User的操作，这里并不涉及到数据库
 */
public class User {
    private Integer userId;
    private String userName;
    private String userPassword;

    private String roleName;
    private String account; //意义不明，想删

    public Integer getUserId(){return userId;}

    //userName
    public String getUserName(){return userName;}
    public void setUserName(String userName){this.userName = userName.trim();}
    //userPassword
    public String getUserPassword(){return userPassword;}
    public void setUserPassword(String userPassword){this.userPassword = userPassword;}
    //roleName
    public String getRoleName(){return roleName;}
    public void setRoleName(String roleName){this.roleName=roleName;}
    //account
    public String getAccount(){return account;}
    public void setAccount(String account){this.account=account;}
}
