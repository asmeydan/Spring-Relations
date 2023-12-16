package com.asmeydan.relation.service;

import com.asmeydan.relation.model.Person;
import com.asmeydan.relation.model.Post;

import java.util.List;

public interface IPersonService {

    public List<Person> findAll();

    public Person findById(int id);

    public Person addPerson(Person person);

    public Person updatePerson(int id, Person person);

    public void deletePerson(int id);

    public Post addPost(int personId, Post post);
}
