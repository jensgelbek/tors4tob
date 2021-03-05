/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entites.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class PersonsDTO {
    List<PersonDTO> personsDTO;

    public PersonsDTO() {
    personsDTO=new ArrayList<>();
    }

    public PersonsDTO(List<Person> persons) {
         personsDTO=new ArrayList<>();
         for(Person p:persons){
             personsDTO.add(new PersonDTO(p));
         }
    }

    public List<PersonDTO> getPersonsDTO() {
        return personsDTO;
    }
    
}
