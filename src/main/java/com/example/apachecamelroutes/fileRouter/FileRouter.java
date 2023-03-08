package com.example.apachecamelroutes.fileRouter;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class FileRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/input").routeId("my-second-route")
                .log("${body}")
                .to("file:files/output");
    }
}
