package com.epam.prac.service;

import org.springframework.stereotype.Service;

@Service
public class Customer implements PracOpe {
    @Override
    public void print() {
        System.out.println("Customer : Hi in Print! ");
    }

    @Override
    public void doSomething() {
        System.out.println("Customer : Hi in doSomething! ");
    }

    @Override
    public void editSomething() {
        System.out.println("Customer : Hi in editSomething! ");
    }
}
