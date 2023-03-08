package com.example.apachecamelroutes.routes;

import lombok.RequiredArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class CustomRouter extends RouteBuilder {


    final CustomBean customBean;

    @Override
    public void configure() throws Exception {
        //queue
        //transformation
        // log


        // be gelen log: Exchange[ExchangePattern: InOnly, BodyType: null, Body: [Body is null]]
//        Exchange[ExchangePattern: InOnly, BodyType: String, Body: 2023-03-08T12:16:03.555499700]

        //@formatter:off
        from("timer:first-timer").routeId("my-first-route")
                .log(LoggingLevel.INFO, "first-timer- : ${body}")
//               .transform().constant("My constant message ")
//               .transform().constant(String.format("%s", LocalDate.now()))// -->  first-timer- : 2023-03-08
                .bean(customBean,"getCurrentDateandTime")    // /first-timer- : 2023-03-08T12:16:04.569003200
                .process(new SimpleStringProcessor())
                .log(LoggingLevel.INFO, "first-timer- : ${body}")
        .to("aws-sqs:https://sqs.us-east-1.amazonaws.com/193916285926/product-queu");

        //@formatter:on
    }
}
