/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserver;

import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import message.Projet;

/**
 *
 * @author Patrice Torguet
 */
@Singleton
@LocalBean
public class ProjetSingleton {
    
    private final HashMap<Integer, Projet> projets;

    public ProjetSingleton() {
        projets = new HashMap<>();
    }

    public HashMap<Integer, Projet> getProjets() {
        return projets;
    }
    
    public void ajouterProjet(Projet unProjet){
        this.projets.put(unProjet.getIdProjet(), unProjet);

    }

}
