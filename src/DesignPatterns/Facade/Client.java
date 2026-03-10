package DesignPatterns.Facade;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
    private final OrderFacade orderFacade;

    public Client(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }
    public void payAndBuy() throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var httpRequest = HttpRequest.newBuilder()
                        .uri(URI.create("/xyz")).build();
        client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        orderFacade.payAndBuy();
    }


}
