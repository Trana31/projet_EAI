package app;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;
import message.Nommage;
import message.Projet;

/**
 *
 * @author 
 * alimente le topic traitement_projet
 */
public class GenerateurProjet extends ClientJMS {

    private MessageProducer mp;
    private MessageConsumer mc;

    public GenerateurProjet() {
 
    }

    private void setProducerConsumer() {

        try {
            // recuperation de la destination
            Destination traitementProjet = (Destination) namingContext.lookup(Nommage.TRAITEMENT_PROJET);
            Destination infosRessourcePrefacture = (Destination) namingContext.lookup(Nommage.INFOS_RESSOURCES_PREFACTURE);
            System.out.println("Destination lookup done.");

            // creation du producteur
            mp = session.createProducer(traitementProjet);
            mc = session.createConsumer(infosRessourcePrefacture);
            
            System.out.println("J'écoute infos ressource :");
            System.out.println(mc.toString());

        } catch (Exception ex) {
            Logger.getLogger(GenerateurProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void runSimu() throws JMSException {

        Date uneDate = new Date(2017, 4, 11);
        Projet unProjet = new Projet(0, "A", "A", "A", "A", 100, uneDate, 0, 0, "A", "A", "A", "A", "A", "A", "A");
        
        ObjectMessage msg1 = session.createObjectMessage(unProjet);
        
        System.out.println("Envoi du projet " + unProjet.toString());
        
        mp.send(msg1);
       
    }

    /**
     * @param args the command line arguments
     * @throws javax.jms.JMSException
     * @throws javax.naming.NamingException
     */
    public static void main(String[] args) throws JMSException, NamingException {

        GenerateurProjet gc = new GenerateurProjet();
        gc.initJMS();
        gc.setProducerConsumer();
        gc.startJMS();
        gc.runSimu();
        //gc.closeJMS();
    }

}
