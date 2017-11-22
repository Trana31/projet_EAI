package app;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import message.Projet;
import message.Nommage;
import message.Salle;
import webserver.SalleSingleton;

/**
 *
 * @author elavinal
 */
public class GestionSalleListener implements MessageListener {
    
    @EJB
    SalleSingleton salles;
    
    private final MessageProducer mp;
    private final Session session;

    public GestionSalleListener(Session session, MessageProducer mp) {
        this.session = session;
        this.mp = mp;
    }

    @Override
    public void onMessage(Message message) {

        try {
            Topic source = (Topic) message.getJMSDestination();

            // System.out.println("MSG RECU " + source.getTopicName());
            String topicName = source.getTopicName().replace('_', '/');

            if (topicName.equalsIgnoreCase(Nommage.TRAITEMENT_PROJET)) {

                if (message instanceof ObjectMessage) {
                    ObjectMessage om = (ObjectMessage) message;
                    Object obj = om.getObject();
                    if (obj instanceof Projet) {
                        
                        int capaciteProjet = ((Projet) obj).getNbrParticipant();
                        Date dateProjet = ((Projet) obj).getDateManif();
                        
                        HashMap lesSalles = salles.getSalles();
                        
                        Salle laSalleEnvoye = null;
                        
                        int i = 0;
                        boolean salleTrouve = false;
                        
                        while(i<lesSalles.size() || salleTrouve){
                            Salle uneSalle = (Salle)lesSalles.get(i);
                            
                            if(uneSalle.getCapacite() > capaciteProjet){
                                if(!uneSalle.getLesdates().contains(dateProjet)){
                                    ArrayList lesDates = salles.getSalles().get(i).getLesdates();
                                    lesDates.add(dateProjet);
                                    
                                    salles.getSalles().get(i).setLesdates(lesDates);
                                    
                                    laSalleEnvoye = salles.getSalles().get(i);
                                    
                                    salleTrouve = true;
                                }
                            }
                        }
                        
                        ObjectMessage msg = session.createObjectMessage(laSalleEnvoye);
                        mp.send(msg);
                    }
                }
            }

            /*if (topicName.equalsIgnoreCase(Nommage.INFOS_RESSOURCES_PREFACTURE)) {

                if (message instanceof ObjectMessage) {
                    ObjectMessage om = (ObjectMessage) message;
                    Object obj = om.getObject();
                    if (obj instanceof Salle) {
                      

                      
                    }
                }

            }*/
        } catch (JMSException ex) {
            Logger.getLogger(GestionRestaurationListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//ici on recoit la date et la capacite depuis la ficheprojet mais non la reference
  //  private static boolean verifierCapaciteSalle(java.lang.String Reference) {
        //parcourir la iste des salles existantes //comparer la capacite
        //envoie la dispo
     //   return true;
  //  }
    
   

}
