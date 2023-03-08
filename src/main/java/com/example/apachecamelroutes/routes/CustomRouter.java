package com.example.apachecamelroutes.routes;

import lombok.RequiredArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class CustomRouter extends RouteBuilder{




    final CustomBean customBean;

    @Override
    public void configure() throws Exception {
       //queue
       //transformation
       // log


        // be gelen log: Exchange[ExchangePattern: InOnly, BodyType: null, Body: [Body is null]]
       from("timer:first-timer")
//               .transform().constant("My constant message ")
//               .transform().constant(String.format("%s", LocalDate.now()))// -->  first-timer- : 2023-03-08
               .bean(customBean)

               .log(LoggingLevel.INFO,"first-timer- : ${body}")

        .to("log:first-timer");
    }
}
