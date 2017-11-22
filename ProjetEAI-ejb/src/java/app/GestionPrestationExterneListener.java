package app;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import message.Nommage;

/**
 *
 * @author elavinal
 */
public class GestionPrestationExterneListener implements MessageListener {

    private final MessageProducer mp;
    private final Session session;

    public GestionPrestationExterneListener(Session session, MessageProducer mp) {
        this.session = session;
        this.mp = mp;
    }

    @Override
    public void onMessage(Message message) {
/*
        try {
            Topic source = (Topic) message.getJMSDestination();

            // System.out.println("MSG RECU " + source.getTopicName());
            String topicName = source.getTopicName().replace('_', '/');

            if (topicName.equalsIgnoreCase(Nommage.TRAITEMENT_PROJET)) {

                if (message instanceof ObjectMessage) {
                    ObjectMessage om = (ObjectMessage) message;
                    Object obj = om.getObject();
                    if (obj instanceof Commande) {
                        Commande cmd = (Commande) obj;
                        System.out.println("Commande " + cmd.getNumCommande() + " reçue --> vérifier coord. bancaires");
                        String iban = cmd.getClient().getIban();
                        // System.out.println("IBAN : " + iban);
                        // TODO: Client SOAP ou REST pour effectuer la vérif
                        
                        if (verifierCoordonnees(iban)){
                            // Vérif OK (~ 70%)
                            cmd.setBanqueValide(true);
                            System.out.println("\t --> Coord. bancaires OK");
                        } else {
                            // Vérif KO (~ 30%)
                            cmd.setBanqueValide(false);
                            System.out.println("\t --> Coord. bancaires NOK");
                        }
                        
                        /*
                        // Ici, simu par tirage aléatoire
                        double r = Math.random();
                        if (r > 0.3) {
                            // Vérif OK (~ 70%)
                            cmd.setBanqueValide(true);
                            System.out.println("\t --> Coord. bancaires OK");
                        } else {
                            // Vérif KO (~ 30%)
                            cmd.setBanqueValide(false);
                            System.out.println("\t --> Coord. bancaires NOK");
                        }*/
                        // envoi de la réponse de la banque
                        /*ObjectMessage msg = session.createObjectMessage(cmd);
                        mp.send(msg);
                    }
                }
            }

            if (topicName.equalsIgnoreCase(Nommage.INFOS_RESSOURCES_PREFACTURE)) {

                if (message instanceof ObjectMessage) {
                    ObjectMessage om = (ObjectMessage) message;
                    Object obj = om.getObject();
                    if (obj instanceof Commande) {
                        Commande cmd = (Commande) obj;
                        System.out.println("Commande " + cmd.getNumCommande() + " traitée reçue --> effectuer débit");
                        System.out.println("\t TODO...");

                        // TODO: Client SOAP ou REST pour effectuer le débit
                    }
                }

            }
        } catch (JMSException ex) {
            Logger.getLogger(GestionPrestationExterneListener.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
    }

    private static boolean verifierCoordonnees(java.lang.String iban) {
        /*clients_ws.ServiceBanque_Service service = new clients_ws.ServiceBanque_Service();
        clients_ws.ServiceBanque port = service.getServiceBanquePort();*/
        return true;
    }

}
