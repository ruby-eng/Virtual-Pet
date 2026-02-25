package Backend.java.Api;

import Backend.java.pet.Pet;
import Backend.java.pet.PetService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class PetHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

        if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            exchange.sendResponseHeaders(204, -1);
            return;
        }

        String path = exchange.getRequestURI().getPath();

        if (path.equals("/feed")) {
            PetService.feedPet();
        } else if (path.equals("/play")) {
            PetService.playwithPet();
        } else if (path.equals("/sleep")) {
            PetService.putPettosleep();
        }

        Pet pet = PetService.getPet();

        String response = "{"
                + "\"hunger\":" + pet.getHunger() + ","
                + "\"happiness\":" + pet.getHappiness() + ","
                + "\"energy\":" + pet.getEnergy()
                + "}";

        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

