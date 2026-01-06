/**
 * Interface de repository pour l'accès aux données des comptes bancaires.
 * Utilise Spring Data JPA pour les opérations CRUD.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
package org.example.demo.repositories;

import org.example.demo.entitise.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA pour la gestion des comptes bancaires.
 * Hérite des méthodes CRUD standard de JpaRepository.
 * 
 * @author Ilyas MICHICH
 */
@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    // Méthodes CRUD héritées de JpaRepository
    // findAll(), findById(), save(), deleteById(), etc.
}
