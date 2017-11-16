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
public class GestionPrestationExterne extends ClientJMS {

    private MessageConsumer mc1;
    private MessageProducer mp1;

    public GestionPrestationExterne() {

    }


    private void setProducerConsumer() {

        try {
            //il est producteur de ACTION_PRESTATION  et il est consommeur de INFOS_PRESTATION
            Destination actionPrestation = (Destination) namingContext.lookup(Nommage.ACTION_PRESTATION);
            Destination infosPrestation = (Destination) namingContext.lookup(Nommage.INFOS_PRESTATION);
            System.out.println("Destination lookup done.");

            // creation des consommateurs et du producteur
            mc1 = session.createConsumer(actionPrestation);
            mp1 = session.createProducer(infosPrestation);

            // TODO. Il faudrait un Listener par consommateur.
            // Je vais au plus rapide là...
            //code métier 
            
            //traitement pour la file infosRessourcePrefacture, actionPrestation
            GestionPrestationExterneListener fl = new GestionPrestationExterneListener(session, mp1);
            mc1.setMessageListener(fl);

        } catch (JMSException | NamingException ex) {
            Logger.getLogger(GenerateurProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        GestionPrestationExterne monServiceFacturation = new GestionPrestationExterne();
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
