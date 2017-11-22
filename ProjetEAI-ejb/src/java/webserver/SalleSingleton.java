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
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import message.Projet;
import message.Salle;

/**
 *
 * @author Patrice Torguet
 */
@Singleton
@LocalBean
public class SalleSingleton {
    
    private final HashMap<Integer, Salle> salles;

    public SalleSingleton() {
        //toutes les salles sont libres en même temps
        ArrayList lesDates = new ArrayList();

        Salle s1 = new Salle("S1", "salle1", 100, 1000, lesDates);
        Salle s2 = new Salle("S1", "salle2", 200, 250, lesDates);
        Salle s3 = new Salle("S1", "sall3", 300, 300, lesDates);
        Salle s4 = new Salle("S1", "salle4", 50, 200, lesDates);
        Salle s5 = new Salle("S1", "salle5", 50, 190, lesDates);
        Salle s6 = new Salle("S1", "salle6", 250, 250 , lesDates);        
        
        salles = new HashMap<>();
        salles.put(1, s1);
        salles.put(2, s2);
        salles.put(3, s3);
        salles.put(4, s4);
        salles.put(5, s5);
        salles.put(6, s6);
    }

    public HashMap<Integer, Salle> getSalles() {
        return salles;
    }
    

}
