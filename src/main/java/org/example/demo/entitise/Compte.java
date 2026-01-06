/**
 * Entité JPA représentant un compte bancaire.
 * Mappée sur la table 'compte' de la base de données.
 * 
 * @author Ilyas MICHICH
 * @version 1.0
 * @since 2024
 */
package org.example.demo.entitise;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Entité représentant un compte bancaire dans le système.
 * Contient les informations essentielles : identifiant, solde, date de création et type.
 * 
 * @author Ilyas MICHICH
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "CompteBancaire")
@XmlAccessorType(XmlAccessType.FIELD)
public class Compte {
    
    /** Identifiant unique du compte bancaire */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /** Solde actuel du compte en dirhams */
    private double solde;

    /** Date de création du compte bancaire */
    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    /** Type du compte (DEBIT ou CREDIT) */
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
}
