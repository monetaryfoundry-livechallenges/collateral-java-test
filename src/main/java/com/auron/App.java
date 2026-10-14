package com.heldnav;

import com.heldnav.http.BorrowHandler;
import com.heldnav.http.HealthHandler;
import com.heldnav.http.MarketHandler;
import com.heldnav.http.PositionHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public final class App {
    private App() {
    }

    public static void main(String[] args) throws IOException {
        int port = 8080;
        String configured = System.getenv("PORT");
        if (configured != null && !configured.isBlank()) {
            port = Integer.parseInt(configured);
        }
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/health", new HealthHandler());
        server.createContext("/v1/markets", new MarketHandler());
        server.createContext("/v1/positions", new PositionHandler());
        server.createContext("/v1/borrow-check", new BorrowHandler());
        server.start();
        System.out.println("Heldnav risk service listening on :" + port);
    }
}
