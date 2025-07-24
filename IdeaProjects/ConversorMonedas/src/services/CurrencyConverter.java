package services;

import api.ExchangeRateClient;
import com.google.gson.Gson;
import exceptions.ApiException;
import models.Currency;

public class CurrencyConverter {
    private final ExchangeRateClient apiClient;
    private final Gson gson = new Gson();

    public CurrencyConverter(String apiKey) {
        this.apiClient = new ExchangeRateClient(apiKey);
    }

    public double convert(double amount, String from, String to) throws ApiException {
        try {
            String json = apiClient.getExchangeData(from);
            Currency currency = gson.fromJson(json, Currency.class);

            if (!currency.isSuccess()) {
                throw new ApiException("La API respondió con error");
            }

            Double rate = currency.getConversionRates().get(to);
            if (rate == null) {
                throw new ApiException("Moneda no soportada: " + to);
            }

            return amount * rate;
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }
}
