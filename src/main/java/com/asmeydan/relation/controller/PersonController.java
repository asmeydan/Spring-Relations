package com.asmeydan.relation.controller;

import com.asmeydan.relation.model.Person;
import com.asmeydan.relation.model.Post;
import com.asmeydan.relation.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson() {
        List<Person> persons = personService.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPersonById(@PathVariable int personId) {
        Person person = personService.findById(personId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.addPerson(person);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @PostMapping("/{personId}")
    public ResponseEntity<Person> updatePerson(@PathVariable int personId, @RequestBody Person person) {
        Person updatedPerson = personService.updatePerson(personId, person);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable int personId) {
        personService.deletePerson(personId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/add-post/{personId}")
    public ResponseEntity<Post> addPost(@PathVariable int personId, @RequestBody Post post) {
        Post addedPost = personService.addPost(personId, post);
        return ResponseEntity.ok(addedPost);
    }
}
