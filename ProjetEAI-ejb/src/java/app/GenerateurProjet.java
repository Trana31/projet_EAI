package app;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;
import message.Nommage;

/**
 *
 * @author 
 * alimente le topic traitement_projet
 */
public class GenerateurProjet extends ClientJMS {

    private MessageProducer mp;

    public GenerateurProjet() {

    }

    private void setProducerConsumer() {

        try {
            // recuperation de la destination
            Destination dest = (Destination) namingContext.lookup(Nommage.TRAITEMENT_PROJET);
            System.out.println("Destination lookup done.");

            // creation du producteur
            mp = session.createProducer(dest);

        } catch (Exception ex) {
            Logger.getLogger(GenerateurProjet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void runSimu() {

        

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
        gc.closeJMS();
    }

}
