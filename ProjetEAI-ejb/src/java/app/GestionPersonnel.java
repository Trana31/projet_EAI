package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.naming.NamingException;
import message.Nommage;

/**
 *
 * @author 
 */
public class GestionPersonnel extends ClientJMS {

    private MessageConsumer mc1;
    private MessageConsumer mc2;
    private MessageProducer mp1;
    private MessageProducer mp2;

    public GestionPersonnel() {

    }


    private void setProducerConsumer() {

        try {
            
            // recuperation des destinations
            Destination traitementProjet = (Destination) namingContext.lookup(Nommage.TRAITEMENT_PROJET);
            Destination infosRessourcePrefacture = (Destination) namingContext.lookup(Nommage.INFOS_RESSOURCES_PREFACTURE);
            
            //il est producteur de ACTION_PRESTATION  et il est consommeur de INFOS_PRESTATION
            Destination actionPrestation = (Destination) namingContext.lookup(Nommage.ACTION_PRESTATION);
            Destination infosPrestation = (Destination) namingContext.lookup(Nommage.INFOS_PRESTATION);
            System.out.println("Destination lookup done.");

            // creation des consommateurs et du producteur
            mc1 = session.createConsumer(infosPrestation);
            mc2 = session.createConsumer(traitementProjet, "JMSType='" + Nommage.MSG_PERSONNEL + "'");
            mp1 = session.createProducer(infosRessourcePrefacture);
            mp2 = session.createProducer(actionPrestation);

            // TODO. Il faudrait un Listener par consommateur.
            // Je vais au plus rapide là...
            //code métier 
            
            //traitement pour la file infosRessourcePrefacture, actionPrestation
            GestionPersonnelListener fl = new GestionPersonnelListener(session, mp1, mp2);
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

        GestionPersonnel monServiceFacturation = new GestionPersonnel();
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
