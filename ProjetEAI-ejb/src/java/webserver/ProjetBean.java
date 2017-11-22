/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import message.Projet;


/**
 *
 * @author Patrice Torguet
 */
@Stateless
public class ProjetBean {
    
    @EJB
    ProjetSingleton projet;
    
    public String annulerProjet(String idProjet){
        return "ok";
    }
    
    public String etablirPreFacturation(String idProjet){
        return "maPrefacture";
    }
    
    public String creerFicheProjet(String nomClient, String coordClient, String appelManif, String typeManif, int nbrParticipant, Date dateManif, int trancheHorDeb, int trancheHorFin, String typePresta, String boissonCocktail, String vinsLunch, String animation, String prestaDeco, String prestaComEvenement, String PrestaSecu){
        int idProjet = projet.getProjets().size();
        
        Projet unProjet = new Projet(idProjet, nomClient, coordClient, appelManif, typeManif, nbrParticipant, dateManif, trancheHorDeb, trancheHorFin, typePresta, boissonCocktail, vinsLunch, animation, prestaDeco, prestaComEvenement, PrestaSecu);
        
        projet.ajouterProjet(unProjet);

        return unProjet.toString();
    }
    
    public String consulterProjet(int idProjet){
        return projet.getProjets().get(idProjet).toString();
    }
    
    public String ConsulterRessources(String idProjet){
        return "ressource";
    }
}
