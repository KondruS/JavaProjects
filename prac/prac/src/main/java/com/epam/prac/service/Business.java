package com.epam.prac.service;

import org.springframework.stereotype.Service;

@Service("BUS")
public class Business implements PracOpe {
    @Override
    public void print() {
        System.out.println(" Business: Hi in Print! ");
    }

    @Override
    public void doSomething() {
        System.out.println(" Business: Hi in doSomething! ");
    }

    @Override
    public void editSomething() {
        System.out.println(" Business: Hi in editSomething! ");
    }
}
