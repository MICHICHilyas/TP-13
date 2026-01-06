/**
 * Configuration Apache CXF pour l'exposition du service Web SOAP.
 * Gère la publication du endpoint SOAP sur le serveur.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
package org.example.demo.config;

import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.example.demo.ws.CompteSoapService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuration pour Apache CXF.
 * Définit le bean EndpointImpl pour exposer le service Web SOAP.
 * 
 * @author Ilyas MICHICH
 */
@Configuration
@AllArgsConstructor
public class CxfConfig {

    /** Service SOAP de gestion des comptes bancaires */
    private CompteSoapService serviceSoapCompte;
    
    /** Bus Apache CXF pour la gestion des transports */
    private Bus busCxf;

    /**
     * Crée et configure le point de terminaison SOAP.
     * Publie le service à l'adresse /ws.
     * 
     * @return EndpointImpl configuré et publié
     */
    @Bean
    public EndpointImpl pointTerminaison() {
        EndpointImpl endpoint = new EndpointImpl(busCxf, serviceSoapCompte);
        endpoint.publish("/ws");
        return endpoint;
    }
}
