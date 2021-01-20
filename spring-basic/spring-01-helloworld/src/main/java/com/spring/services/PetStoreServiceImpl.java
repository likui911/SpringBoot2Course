package com.spring.services;

import com.spring.dao.AccountDao;
import com.spring.dao.ItemDao;

import java.util.ArrayList;
import java.util.List;


public class PetStoreServiceImpl implements PetStoreService{
    private AccountDao accountDao;
    private ItemDao itemDao;


    public PetStoreServiceImpl() {
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public String toString() {
        return "PetStoreServiceImpl{" +
                "accountDao=" + accountDao +
                ", itemDao=" + itemDao +
                '}';
    }

    public List<String> getUsernameList() {
        List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("Oracle");
        list.add("CSS");
        list.add("XML");
        return list;
    }
}
