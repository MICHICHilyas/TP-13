/**
 * Application principale du service Web SOAP JAX-WS avec Spring Boot.
 * Point d'entrée de l'application bancaire SOAP.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
package org.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale qui démarre l'application Spring Boot.
 * Configure automatiquement les composants du service SOAP.
 * 
 * @author Ilyas MICHICH
 */
@SpringBootApplication
public class Tp13SoapApplication {

    /**
     * Méthode principale de démarrage de l'application.
     * Lance le contexte Spring Boot et initialise le service SOAP.
     * 
     * @param args Arguments de ligne de commande passés à l'application
     */
    public static void main(String[] args) {
        System.out.println("=== Démarrage du Service SOAP Bancaire - Ilyas MICHICH ===");
        SpringApplication.run(Tp13SoapApplication.class, args);
        System.out.println("=== Service SOAP initialisé avec succès ===");
    }

}
