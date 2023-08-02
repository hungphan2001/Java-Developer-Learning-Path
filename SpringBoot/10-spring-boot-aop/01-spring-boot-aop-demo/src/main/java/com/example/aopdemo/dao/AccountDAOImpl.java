package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass()+ " Doing y account");
    }
}
