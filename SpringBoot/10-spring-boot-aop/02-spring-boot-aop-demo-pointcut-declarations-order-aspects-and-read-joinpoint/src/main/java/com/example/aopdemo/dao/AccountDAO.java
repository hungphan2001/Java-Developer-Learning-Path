package com.example.aopdemo.dao;

import com.example.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    //add a new method :findAccount()

    List<Account> findAccount();

    List<Account> findAccount(boolean tripWire);
    void addAccount(Account theAccount,boolean vipFlag);
    boolean doWork();

    public String getName() ;

    public void setName(String name) ;

    public String getServiceCode() ;

    public void setServiceCode(String serviceCode);
}
