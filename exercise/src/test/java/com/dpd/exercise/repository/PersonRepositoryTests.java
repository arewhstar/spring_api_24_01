package com.dpd.exercise.repository;

import com.dpd.exercise.entity.Address;
import com.dpd.exercise.entity.Person;
import com.dpd.exercise.entity.Telephone;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PersonRepositoryTests {

    @Autowired
    private PersonRepository personRepository;
    private List<Address> la = new ArrayList<>();
    private List<Telephone> lt = new ArrayList<>();
/*
    @Test
    public void PersonRepository_Save_Test() {


        Address address = Address.builder().text("California").build();
        Address address2 = Address.builder().text("Budapest").build();

        Telephone tel = Telephone.builder().number("+11111111").build();
        Telephone tel2 = Telephone.builder().number("+22222222").build();

        la.add(address);
        la.add(address2);

        lt.add(tel);
        lt.add(tel);

        Person person = Person.builder()
                .name("An Tony")
                .address(la)
                .telephone(lt).build();
        Person createdPerson = personRepository.save(person);
        Assertions.assertThat(createdPerson).isNotNull();
        Assertions.assertThat(createdPerson.getPer_id()).isGreaterThan(0);
        Assertions.assertThat(createdPerson.getAddress().size()).isEqualTo(2);
    }

    @Test
    public void PersonRepository_LoadAll_Test() {

        Person person = Person.builder()
                .name("An Tony")
                .address(la)
                .telephone(lt).build();
        Person person2 = Person.builder()
                .name("Another Tony")
                .address(la)
                .telephone(lt).build();
        personRepository.save(person);
        personRepository.save(person2);
        List<Person> people = personRepository.findAll();
        Assertions.assertThat(people).isNotNull();
        Assertions.assertThat(people.size()).isEqualTo(2);
    }

    @Test
    public void PersonRepository_LoadOne_Test() {

        Person person = Person.builder()
                .name("An Tony")
                .address(la)
                .telephone(lt).build();
        personRepository.save(person);

        Person loadedPerson = personRepository.findById(person.getPer_id()).get();

        Assertions.assertThat(loadedPerson).isNotNull();
    }


    @Test
    public void PersonRepository_Update_Test() {

        Person person = Person.builder()
                .name("An Tony")
                .address(la)
                .telephone(lt).build();
        personRepository.save(person);
        Person createdPerson = personRepository.findById(person.getPer_id()).get();
        createdPerson.setName("Aby");
        Person updatedPerson = personRepository.save(createdPerson);
        Assertions.assertThat(updatedPerson.getName()).isNotNull();

    }

    @Test
    public void PersonRepository_Delete_Test() {

        Person person = Person.builder()
                .name("An Tony")
                .address(la)
                .telephone(lt).build();
        personRepository.save(person);

        personRepository.deleteById(person.getPer_id());
        Optional<Person> deletedPerson = personRepository.findById(person.getPer_id());

        Assertions.assertThat(deletedPerson).isEmpty();
    }

*/
}
