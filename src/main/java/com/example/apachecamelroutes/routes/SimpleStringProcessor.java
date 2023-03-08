package com.example.apachecamelroutes.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;

public class SimpleStringProcessor implements Processor  {
    @Override
    public void process(Exchange exchange) throws Exception {
        String in = exchange.getIn(String.class);
        String s = StringUtils.isBlank(in) ? StringUtils.reverse(in) : "it is blank";
        System.out.println("output is : "+ s);


    }
}
