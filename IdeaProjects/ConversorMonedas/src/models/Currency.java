package models;

import java.util.Map;

public class Currency {
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    public boolean isSuccess() {
        return "success".equals(result);
    }
}