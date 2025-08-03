/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pocketbase.teste;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Objects;

/**
 *
 * @author gilmario
 */
public class HttpserveUtil {

    private static HttpServer httpServer;

    public static void startServerGET(int porta) throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(porta), 0);
        httpServer.createContext("/", (exchange) -> {
            if (!exchange.getRequestMethod().equalsIgnoreCase("get")) {
                exchange.sendResponseHeaders(500, "ERROR".length());
                exchange.getResponseBody().write("ERROR".getBytes());
                exchange.getResponseBody().close();
                return;
            }

            byte[] data = exchange.getRequestURI().getQuery().getBytes();

            exchange.sendResponseHeaders(200, data.length);
            exchange.getResponseBody().write(data);
            exchange.getResponseBody().close();
        });
        httpServer.start();
//            System.out.println("OK");
    }

    public static void startServerPOST(int porta) throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(porta), 0);
        httpServer.createContext("/", (exchange) -> {
            if (!exchange.getRequestMethod().equalsIgnoreCase("post")) {
                exchange.sendResponseHeaders(500, "ERROR".length());
                exchange.getResponseBody().write("ERROR".getBytes());
                exchange.getResponseBody().close();
                return;
            }

            byte[] data = exchange.getRequestBody().readAllBytes();

            exchange.sendResponseHeaders(200, data.length);
            exchange.getResponseBody().write(data);
            exchange.getResponseBody().close();
        });
        httpServer.start();
//            System.out.println("OK");
    }

    public static void stop() {
        if (Objects.nonNull(httpServer)) {
            httpServer.stop(0);
        }
    }

}
