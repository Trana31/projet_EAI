/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Date;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import webserver.ProjetBean;

/**
 *
 * @author Alex-asus
 */
@WebService(serviceName = "ProjetService")
public class ProjetService {

    @EJB
    private ProjetBean ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "annulerProjet")
    public String annulerProjet(@WebParam(name = "idProjet") String idProjet) {
        return ejbRef.annulerProjet(idProjet);
    }

    @WebMethod(operationName = "etablirPreFacturation")
    public String etablirPreFacturation(@WebParam(name = "idProjet") String idProjet) {
        return ejbRef.etablirPreFacturation(idProjet);
    }

    @WebMethod(operationName = "creerFicheProjet")
    public String creerFicheProjet(@WebParam(name = "nomClient") String nomClient, @WebParam(name = "coordClient") String coordClient, @WebParam(name = "appelManif") String appelManif, @WebParam(name = "typeManif") String typeManif, @WebParam(name = "nbrParticipant") int nbrParticipant, @WebParam(name = "dateManif") Date dateManif, @WebParam(name = "trancheHorDeb") int trancheHorDeb, @WebParam(name = "trancheHorFin") int trancheHorFin, @WebParam(name = "typePresta") String typePresta, @WebParam(name = "boissonCocktail") String boissonCocktail, @WebParam(name = "vinsLunch") String vinsLunch, @WebParam(name = "animation") String animation, @WebParam(name = "prestaDeco") String prestaDeco, @WebParam(name = "prestaComEvenement") String prestaComEvenement, @WebParam(name = "PrestaSecu") String PrestaSecu) {
        return ejbRef.creerFicheProjet(nomClient, coordClient, appelManif, typeManif, nbrParticipant, dateManif, trancheHorDeb, trancheHorFin, typePresta, boissonCocktail, vinsLunch, animation, prestaDeco, prestaComEvenement, PrestaSecu);
    }

    @WebMethod(operationName = "consulterProjet")
    public String consulterProjet(@WebParam(name = "idProjet") int idProjet) {
        return ejbRef.consulterProjet(idProjet);
    }

    @WebMethod(operationName = "ConsulterRessources")
    public String ConsulterRessources(@WebParam(name = "idProjet") String idProjet) {
        return ejbRef.ConsulterRessources(idProjet);
    }
    
}
