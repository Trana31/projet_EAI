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
 * @author Alex-asus
 */
public class Projet implements Serializable{
    private int idProjet;
    private String nomClient;
    private String coordClient;
    private String appelManif;
    private String typeManif;
    private int nbrParticipant;
    private Date dateManif;
    private int trancheHorDeb; 
    private int trancheHorFin;
    private String typePresta;
    private String boissonCocktail;
    private String vinsLunch;
    private String animation;
    private String prestaDeco;
    private String prestaComEvenement;
    private String PrestaSecu;

    public Projet(int idProjet, String nomClient, String coordClient, String appelManif, String typeManif, int nbrParticipant, Date dateManif, int trancheHorDeb, int trancheHorFin, String typePresta, String boissonCocktail, String vinsLunch, String animation, String prestaDeco, String prestaComEvenement, String PrestaSecu) {
        this.idProjet = idProjet;
        this.nomClient = nomClient;
        this.coordClient = coordClient;
        this.appelManif = appelManif;
        this.typeManif = typeManif;
        this.nbrParticipant = nbrParticipant;
        this.dateManif = dateManif;
        this.trancheHorDeb = trancheHorDeb;
        this.trancheHorFin = trancheHorFin;
        this.typePresta = typePresta;
        this.boissonCocktail = boissonCocktail;
        this.vinsLunch = vinsLunch;
        this.animation = animation;
        this.prestaDeco = prestaDeco;
        this.prestaComEvenement = prestaComEvenement;
        this.PrestaSecu = PrestaSecu;
    }
    
    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }
    
    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getCoordClient() {
        return coordClient;
    }

    public void setCoordClient(String coordClient) {
        this.coordClient = coordClient;
    }

    public String getAppelManif() {
        return appelManif;
    }

    public void setAppelManif(String appelManif) {
        this.appelManif = appelManif;
    }

    public String getTypeManif() {
        return typeManif;
    }

    public void setTypeManif(String typeManif) {
        this.typeManif = typeManif;
    }

    public int getNbrParticipant() {
        return nbrParticipant;
    }

    public void setNbrParticipant(int nbrParticipant) {
        this.nbrParticipant = nbrParticipant;
    }

    public Date getDateManif() {
        return dateManif;
    }

    public void setDateManif(Date dateManif) {
        this.dateManif = dateManif;
    }

    public int getTrancheHorDeb() {
        return trancheHorDeb;
    }

    public void setTrancheHorDeb(int trancheHorDeb) {
        this.trancheHorDeb = trancheHorDeb;
    }

    public int getTrancheHorFin() {
        return trancheHorFin;
    }

    public void setTrancheHorFin(int trancheHorFin) {
        this.trancheHorFin = trancheHorFin;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getBoissonCocktail() {
        return boissonCocktail;
    }

    public void setBoissonCocktail(String boissonCocktail) {
        this.boissonCocktail = boissonCocktail;
    }

    public String getVinsLunch() {
        return vinsLunch;
    }

    public void setVinsLunch(String vinsLunch) {
        this.vinsLunch = vinsLunch;
    }

    public String getAnimation() {
        return animation;
    }

    public void setAnimation(String animation) {
        this.animation = animation;
    }

    public String getPrestaDeco() {
        return prestaDeco;
    }

    public void setPrestaDeco(String prestaDeco) {
        this.prestaDeco = prestaDeco;
    }

    public String getPrestaComEvenement() {
        return prestaComEvenement;
    }

    public void setPrestaComEvenement(String prestaComEvenement) {
        this.prestaComEvenement = prestaComEvenement;
    }

    public String getPrestaSecu() {
        return PrestaSecu;
    }

    public void setPrestaSecu(String PrestaSecu) {
        this.PrestaSecu = PrestaSecu;
    }

    @Override
    public String toString() {
        return "Projet{" + "idProjet=" + idProjet + ", nomClient=" + nomClient + ", coordClient=" + coordClient + ", appelManif=" + appelManif + ", typeManif=" + typeManif + ", nbrParticipant=" + nbrParticipant + ", dateManif=" + dateManif + ", trancheHorDeb=" + trancheHorDeb + ", trancheHorFin=" + trancheHorFin + ", typePresta=" + typePresta + ", boissonCocktail=" + boissonCocktail + ", vinsLunch=" + vinsLunch + ", animation=" + animation + ", prestaDeco=" + prestaDeco + ", prestaComEvenement=" + prestaComEvenement + ", PrestaSecu=" + PrestaSecu + '}';
    }
    
}
