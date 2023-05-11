package com.epam.prac.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Operation {
    private final PracOpe customer;
    private final PracOpe BUS;

 /*   @Autowired
    private PracOpe BUS;

    @Autowired
    private PracOpe customer;*/

    void startShow(){
        BUS.doSomething();
        customer.print();
    }
}
