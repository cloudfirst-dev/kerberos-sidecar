package org.my.group;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("/hi")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@Context  HttpHeaders headers) {
        headers.getRequestHeaders().forEach((k,v) -> {
            System.out.print(k + ": ");
            v.forEach(e -> {
                System.out.println(e);
            });
            System.out.println("");
        });

        return headers.getRequestHeaders().getFirst("X-Remote-User");
    }
}