/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MeteoCal.business.security.boundary;
import MeteoCal.business.security.entity.Group;
import MeteoCal.business.security.entity.Users;
import java.security.Principal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author DeMaria
 */
@Stateless
public class UserManager implements UserManagerInterface {
    
    @PersistenceContext
    EntityManager em;
   
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    
    @Inject
    Principal principal;
   
    
    
        /**
     *
     * @return a list with all registered users
     */
    @Override
    public List<String> getListUsers() {
        Query query;
        query = em.createQuery("SELECT e.mail FROM Users e WHERE e.mail!= :usermail").setParameter("usermail", principal.getName());
        List<String> user;
        user = query.getResultList();
        return user;
    }

        /**
     * this function search in the database if there is a user with the email
     * passed from parameters
     *
     * @param mail
     * @return the user
     */
    @Override
    public Users findByMail(String mail) {

        Query query;
        query = em.createQuery("SELECT u FROM Users u WHERE u.mail= :mail ").setParameter("mail", mail);

        List<Users> user = query.getResultList();
        if (!user.isEmpty()) {
            return user.get(0);
        }
        return null;

    }
    
        /**
     * This function sets the calendar of the user passed from parameters as the
     * value status
     *
     * @param status
     * @param user
     */
  @Override
    public void setCalendar(boolean status, Users user) {

        try {

            Query query = em.createQuery("UPDATE Users SET publicCalendar= :status where mail= :user");
            query.setParameter("status", status);
            query.setParameter("user", user.getMail());
            query.executeUpdate();

        } catch (Exception e) {
            System.out.println("Errore nella query setCalendar");
        }
    }

    
        /**
     *
     * @return a list of emails that contains all users with calendar sets as
     * public
     */
   @Override
    public List<String> getListUsersPublic() {

        Query query;
        query = em.createQuery("SELECT e.mail FROM Users e WHERE e.mail!= :usermail and e.publicCalendar=1").setParameter("usermail", principal.getName());
        List<String> user;
        user = query.getResultList();
        return user;
    }


    @Override
    public void save(Users user) throws Exception {

        user.setGroupName(Group.USERS);
        em.persist(user);

    }

   @Override
    public void unregister() {
        em.remove(getLoggedUser());
    }

  @Override
    public Users getLoggedUser() {
        return em.find(Users.class, principal.getName());

    }
    
//    Query query;
//    
//        public void save(Users users) {
//        
//        //creo un nuovo calendario    
//        Calendar calendar =new Calendar();
//        calendar.setIsPublic(Boolean.TRUE);
//        
//        //assegno al nuovo utente il calendario creato
//        users.setCalendaridCalendar(calendar);
//        
//        users.setGroupName(Group.USERS);
//        
//        //salvo calendario e utente
//        em.persist(calendar);
//        em.persist(users);
//        
//        //Query pippo =em.createQuery("SELECT u FROM Users u");
//        //TypedQuery<Users> pippo = em.createNamedQuery(Users.findAll, Users.class);
//            
//        //Query q = em.createQuery("SELECT u.name FROM Users u WHERE u.name LIKE 'g%'");
//        //List<Users> l = pippo.getResultList();
//        
//        
//        List<String> s = em.createNamedQuery(Users.complete).setParameter("value", "g").getResultList();
//        
//        System.out.println("RISULTATO=>" + s.get(0));
//        
//    }
//
//    public void findAllUsers(){
//        //TypedQuery<Users> query = em.createNamedQuery(Users.findAll, Users.class);
//    }    
//        
//    /**
//     * unregister the actual user logged
//     */    
//    public void unregister() {
//        em.remove(getLoggedUser());
//    }
//
//
//    /**
//     * ritorna l'utente attualmente connesso
//     * @return 
//     */
//    public Users getLoggedUser() {
//        return em.find(Users.class, principal.getName());
//    }
//    
//    
//    
//    //cerca tutti gli utenti che hanno quel nome
//    //e il loro calendario è pubblico
//    public List<Users> searchUsers(Users users){
//        
//      query= em.createQuery("SELECT u FROM Users u WHERE u.name = name and u.idCalendar IN(SELECT c.idCalendar from calendar c WHERE c.isPublic=1) ").setParameter("name",users.getName());
//      List<Users> u;
//      u=query.getResultList();
//      return u;
//    } 
//    
//    public List<String> complete(String value){
//        
//      //Query q = em.createQuery("SELECT u.name FROM Users u WHERE u.name LIKE ' :value %'").setParameter("value", value);
//      
//        return em.createNamedQuery(Users.complete).setParameter("valore", value).getResultList();
//    
//    }
//    

    
    

    
}
