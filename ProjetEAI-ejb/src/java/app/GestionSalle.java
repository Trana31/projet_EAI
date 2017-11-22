package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.naming.NamingException;
import message.Nommage;
import webserver.SalleSingleton;

/**
 *
 * @author 
 */
public class GestionSalle extends ClientJMS {
    
    private MessageConsumer mc1;
    private MessageConsumer mc2;
    private MessageProducer mp;

    public GestionSalle() {

    }


    private void setProducerConsumer() {

        try {
            
            // recuperation des destinations
            Destination traitementProjet = (Destination) namingContext.lookup(Nommage.TRAITEMENT_PROJET);
            Destination infosRessourcePrefacture = (Destination) namingContext.lookup(Nommage.INFOS_RESSOURCES_PREFACTURE);
            System.out.println("Destination lookup done.");

            // creation des consommateurs et du producteur
            mc2 = session.createConsumer(traitementProjet, "JMSType='" + Nommage.MSG_SALLE + "'");
            mp = session.createProducer(infosRessourcePrefacture);

            // TODO. Il faudrait un Listener par consommateur.
            // Je vais au plus rapide là...
            //code métier 
            GestionSalleListener fl = new GestionSalleListener(session, mp);
            mc1.setMessageListener(fl);
            mc2.setMessageListener(fl);

        } catch (JMSException | NamingException ex) {
            Logger.getLogger(GenerateurProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        GestionSalle monServiceFacturation = new GestionSalle();
        monServiceFacturation.initJMS();
        monServiceFacturation.setProducerConsumer();
        monServiceFacturation.startJMS();
        System.out.println("*** Service de facturation démarré. ***");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Appuyez sur 'Q' pour quitter.");
        } while (!br.readLine().equalsIgnoreCase("Q"));
        monServiceFacturation.closeJMS();
    }

}
