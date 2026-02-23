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
        String path = exchange.getRequestURI().getPath();

        if (path.equals("/feed")){
            PetService.feedPet();
        }
        if(path.equals("/play")){
            PetService.playwithPet();
        }
        if (path.equals("/sleep")){
            PetService.putPettosleep();
        }
        Pet pet = PetService.getPet();

        String response = "{"
                +"\"hunger\":" +pet.getHunger() +","
                + "\"happiness\":" + pet.getHappiness() + ","
                + "\"energy\":" + pet.getEnergy()
                + "}";


        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
