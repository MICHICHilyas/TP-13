/**
 * Service Web SOAP pour la gestion des comptes bancaires.
 * Expose les opérations CRUD via le protocole SOAP.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
package org.example.demo.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.example.demo.entitise.Compte;
import org.example.demo.entitise.TypeCompte;
import org.example.demo.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Implémentation du service Web SOAP pour les opérations bancaires.
 * Permet de consulter, créer et supprimer des comptes bancaires.
 * 
 * @author Ilyas MICHICH
 */
@Component
@WebService(serviceName = "ServiceBancaireIlyas")
public class CompteSoapService {

    /** Repository pour l'accès aux données des comptes */
    @Autowired
    private CompteRepository repositoryComptes;

    /**
     * Récupère la liste complète des comptes bancaires.
     * 
     * @return Liste de tous les comptes enregistrés dans le système
     */
    @WebMethod(operationName = "listerTousLesComptes")
    public List<Compte> getComptes() {
        System.out.println("[Ilyas MICHICH] Récupération de tous les comptes bancaires");
        return repositoryComptes.findAll();
    }

    /**
     * Recherche un compte bancaire par son identifiant.
     * 
     * @param identifiantCompte Identifiant unique du compte recherché
     * @return Le compte trouvé ou null si inexistant
     */
    @WebMethod(operationName = "rechercherCompteParId")
    public Compte getCompteById(@WebParam(name = "identifiantCompte") Long identifiantCompte) {
        System.out.println("[Ilyas MICHICH] Recherche du compte N° " + identifiantCompte);
        return repositoryComptes.findById(identifiantCompte).orElse(null);
    }

    /**
     * Crée un nouveau compte bancaire dans le système.
     * 
     * @param montantInitial Solde initial du nouveau compte
     * @param categorieCompte Type du compte à créer
     * @return Le compte créé avec son identifiant généré
     */
    @WebMethod(operationName = "creerNouveauCompte")
    public Compte createCompte(@WebParam(name = "montantInitial") double montantInitial,
                               @WebParam(name = "categorieCompte") TypeCompte categorieCompte) {
        System.out.println("[Ilyas MICHICH] Création d'un nouveau compte - Solde: " + montantInitial + " DH");
        Compte nouveauCompte = new Compte(null, montantInitial, new Date(), categorieCompte);
        return repositoryComptes.save(nouveauCompte);
    }

    /**
     * Supprime un compte bancaire du système.
     * 
     * @param identifiantCompte Identifiant du compte à supprimer
     * @return true si suppression réussie, false si compte inexistant
     */
    @WebMethod(operationName = "supprimerCompte")
    public boolean deleteCompte(@WebParam(name = "identifiantCompte") Long identifiantCompte) {
        System.out.println("[Ilyas MICHICH] Tentative de suppression du compte N° " + identifiantCompte);
        if (repositoryComptes.existsById(identifiantCompte)) {
            repositoryComptes.deleteById(identifiantCompte);
            System.out.println("[Ilyas MICHICH] Compte N° " + identifiantCompte + " supprimé avec succès");
            return true;
        }
        System.out.println("[Ilyas MICHICH] Compte N° " + identifiantCompte + " introuvable");
        return false;
    }
}
