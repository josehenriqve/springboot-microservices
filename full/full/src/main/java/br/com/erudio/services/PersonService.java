package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Random;
@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    //vai gerar um ID novo simulando o ID do banco de dados

    public Person findById(String id) {

        Person person = new Person();
        person.setAddress("Rua Maria Merquides");
        person.setLastName("Ribeiro");
        person.setId(counter.incrementAndGet());
        person.setFirstName("Jose");
        person.setGender("Male");
        return person;

    }

    public Person create(Person person) {
        return person;
    }

    public Person update(Person person) {
        return person;
    }
    public void delete(String id) {

    }
    private Person mockPerson(int i){
        Person person = new Person();
        person.setAddress("Rua Maria Merquides");
        person.setLastName("Ribeiro");
        person.setId(counter.incrementAndGet());
        person.setFirstName("Jose");
        person.setGender("Male");
        return person;
    }
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        for (int i=0;i<=15;i++) {
            Random random = new Random();
            char letra1 = (char) (random.nextInt(26) + 'a');
            Random random1 = new Random();
            char letra2 = (char) (random1.nextInt(26) + 'a');
            Random random2 = new Random();
            char letra3 = (char) (random2.nextInt(26) + 'a');
            Random random3 = new Random();
            char letra4 = (char) (random3.nextInt(26) + 'a');
            Person person = new Person();
            person.setFirstName(letra1+"a"+letra2+"o"+letra3);
            person.setLastName(letra2+"de"+letra1+letra3+letra4);
            person.setAddress("Rua "+letra1);
            person.setGender("Male");
            person.setId(counter.getAndIncrement());
            persons.add(person);
        }

        return persons;

    }
}
