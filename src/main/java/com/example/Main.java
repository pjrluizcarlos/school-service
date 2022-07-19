package com.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {

    public static final String BASE_URI = "http://localhost:8080/";

    public static HttpServer startServer() {
        ResourceConfig rc = new ResourceConfig().packages("com.example");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = startServer();

        System.out.println(String.format("Jersey app started with endpoints available at %s%nHit Ctrl-C to stop it...", BASE_URI));
        System.in.read();

        server.shutdownNow();
    }
}
