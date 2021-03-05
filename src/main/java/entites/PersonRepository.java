
package entites;

import dtos.PersonDTO;
import dtos.PersonsDTO;


public interface PersonRepository {

    public PersonDTO addPerson(String fName, String lName, String phone);

    public PersonDTO deletePerson(int id);

    public PersonDTO getPerson(int id);

    public PersonsDTO getAllPersons();

    public PersonDTO editPerson(PersonDTO p);
}
