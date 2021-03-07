package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entites.PersonRepository;
import entities.renameme.RenameMeRepository;
import facades.FacadeExample;
import facades.PersonFacade;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

public class Provider {

    public static ParentRepository REPO;
    public static Gson GSON;

    static {
        REPO = createRepository();
        GSON = new GsonBuilder().setPrettyPrinting().create();
    }

    //Whenever a new repository is created add it here
    private static ParentRepository createRepository() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();

        RenameMeRepository renameMeRepository = FacadeExample.getFacadeExample(emf);
        PersonRepository personRepository=PersonFacade.getPersonFacade(emf);
        return new ParentRepository(
            renameMeRepository,personRepository
        );
    }
}

//Whenever a new repository is created add it here
class ParentRepository {

    private final RenameMeRepository renameMeRepository;
    private final PersonRepository personRepository;

    ParentRepository(RenameMeRepository renameMeRepository,PersonRepository personRepository) {
        this.renameMeRepository = renameMeRepository;
        this.personRepository=personRepository;
    }

    public PersonRepository getPersonRepository(){
        return personRepository;
    }
    
    public RenameMeRepository getRenameMeRepo() {
        return renameMeRepository;
    }
}