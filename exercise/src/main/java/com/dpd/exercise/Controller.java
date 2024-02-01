package com.dpd.exercise;


import com.dpd.exercise.entity.Person;
import com.dpd.exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("person")
    public ResponseEntity getPerson(@RequestParam long id){
        if (personRepository.existsById(id)) {

        return ResponseEntity.ok(personRepository.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person with id: ("+id+ ") is not found!");
    }

    @GetMapping("people")
    public ResponseEntity<List <Person>> getPeople(){
        return ResponseEntity.ok(personRepository.findAll());
    }

    @PutMapping("person")
    public ResponseEntity<String> updatePerson(@RequestParam long id, @RequestBody Person person){
        if (personRepository.existsById(id)) {
            personRepository.findById(id).get().setName(person.getName());
            personRepository.findById(id).get().setAddress(person.getAddress());
            personRepository.save(person);
            return ResponseEntity.ok("Updated!");
        }

        personRepository.save(person);
        return ResponseEntity.ok("Missing person is created!");
    }

    @PostMapping("person")
    public ResponseEntity<String> createPerson(@RequestBody Person person) {
        try {
            personRepository.save(person);
            return ResponseEntity.ok("Saved!");
        } catch (DataIntegrityViolationException e) {
            // Catch the exception for unique constraint violation (e.g., duplicate email)
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Person already exists");
        }
    }
    @DeleteMapping("person")
    public ResponseEntity<String> deletePerson(@RequestParam long id){
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return ResponseEntity.ok("Deleted!");
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person with id: ("+id+ ") is not found!");


    }


}
