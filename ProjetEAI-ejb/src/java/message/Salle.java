/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Laura
 */
public class Salle implements Serializable{
    
    private String reference;
    private String nom;
    private int capacite;
    private float prix;
    ArrayList<Date>lesdates;
    
    
    //Changer la dispo avec des mapdates 
    //Lorsque le client verifie une date , on compare avec toutes les dates dispo de la salle avec une liste de date

    public Salle(String reference, String nom, int capacite, float prix, ArrayList<Date> lesdates) {
        this.reference = reference;
        this.nom = nom;
        this.capacite = capacite;
        this.prix = prix;
        this.lesdates = lesdates;
    }

    public String getReference() {
        return reference;
    }

    public String getNom() {
        return nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public float getPrix() {
        return prix;
    }

    public ArrayList<Date> getLesdates() {
        return lesdates;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setLesdates(ArrayList<Date> lesdates) {
        this.lesdates = lesdates;
    }
    
}
