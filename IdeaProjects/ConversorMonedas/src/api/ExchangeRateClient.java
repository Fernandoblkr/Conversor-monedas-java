package api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ExchangeRateClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private final String apiKey;

    public ExchangeRateClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getExchangeData(String baseCurrency) throws Exception {
        String url = API_URL + apiKey + "/latest/" + baseCurrency;

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new Exception("Error de API: " + response.body());
        }

        return response.body();
    }
}
