package com.ConversorMonedas;

import services.CurrencyConverter;
import java.util.Scanner;

public class Main {
    private static final String API_KEY = "2328f73aca627b43a2d80ec0";

    public static void main(String[] args) {
        CurrencyConverter conversor = new CurrencyConverter(API_KEY);
        Scanner scanner = new Scanner(System.in);

        System.out.println(" CONVERSOR DE MONEDAS ");

        while (true) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. USD a ARS (Peso argentino)");
            System.out.println("2. USD a BOB (Boliviano boliviano)");
            System.out.println("3. USD a BRL (Real brasileño)");
            System.out.println("4. USD a CLP (Peso chileno)");
            System.out.println("5. USD a COP (Peso colombiano)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (opcion == 6) {
                System.out.println("¡Gracias por usar el conversor!");
                break;
            }

            String monedaDestino;
            switch (opcion) {
                case 1: monedaDestino = "ARS"; break;
                case 2: monedaDestino = "BOB"; break;
                case 3: monedaDestino = "BRL"; break;
                case 4: monedaDestino = "CLP"; break;
                case 5: monedaDestino = "COP"; break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    continue;
            }

            System.out.print("Ingrese la cantidad en USD: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer

            try {
                double resultado = conversor.convert(cantidad, "USD", monedaDestino);
                System.out.printf("\n %.2f USD = %.2f %s\n", cantidad, resultado, monedaDestino);
            } catch (Exception e) {
                System.err.println("\n Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}