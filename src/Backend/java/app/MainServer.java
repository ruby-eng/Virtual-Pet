package Backend.java.app;

import Backend.java.Api.PetHandler;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class MainServer {
    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", new PetHandler());

        server.setExecutor(null);
        server.start();

        System.out.println("Server running on http://localhost:8080");
    }
}

