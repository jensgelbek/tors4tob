/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.PersonDTO;
import dtos.PersonsDTO;
import entites.Person;
import entites.PersonRepository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author PC
 */
public class PersonFacade implements PersonRepository{

    
    private static PersonFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private PersonFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this repository class.
     */
    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    
    
    @Override
    public PersonDTO addPerson(String fName, String lName, String phone) {
            EntityManager em = getEntityManager();
            Person person=new Person(fName,lName,phone);
            try{
                em.getTransaction().begin();
                em.persist(person);
                em.getTransaction().commit();
                return new PersonDTO(person);
            }
            finally{
                em.close();
            }
    }

    @Override
    public PersonDTO deletePerson(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDTO getPerson(int id) {
         EntityManager em = getEntityManager();
         return new PersonDTO(em.find(Person.class, id));
    }

    
    @Override
    public PersonsDTO getAllPersons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDTO editPerson(PersonDTO p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
