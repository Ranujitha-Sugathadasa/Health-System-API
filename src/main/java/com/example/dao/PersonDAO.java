/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.NotFoundException;

public class PersonDAO {
    private static List<Person> persons = new ArrayList<>();
    
    static{
        persons.add(new Person(1, "Alex","0111234567", "3/80, Something Road, Somewhere"));
        persons.add(new Person(2, "Duke","0111234567", "5, Something Road, Somewhere"));
        persons.add(new Person(3, "Will","0111234567", "1, Something Road, Somewhere"));

    }
    public List<Person> getAllPersons() {
        return persons;
    }

    // Adding person
    public void addPerson(Person person) {
        persons.add(person);
    }
    
    
    // Retrieves a person based on person id
    public Person getPerson(int id) throws NotFoundException {
        for (Person person : persons) {
            if (person.getID()== id) {
                return person;
            }
        }
        throw new NotFoundException("Person with this ID " + id + " not found");
    }
    

    // Updating exsting person using getPerson method
    public void updatePerson(int id, Person updatedPerson) throws NotFoundException {
        Person person = getPerson(id);
        person.setName(updatedPerson.getName());
        person.setContactInformation(updatedPerson.getContactInformation());
        person.setAddress(updatedPerson.getAddress());
    }

    // Deleting a person based on Personid
    public void deletePerson(int id) throws NotFoundException {
        Person person = getPerson(id);
        persons.remove(person);
    }
}

