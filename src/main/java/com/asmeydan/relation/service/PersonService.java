package com.asmeydan.relation.service;

import com.asmeydan.relation.model.Person;
import com.asmeydan.relation.model.Post;
import com.asmeydan.relation.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService implements IPersonService {


    private final PersonRepository personRepository;
    private final StringEncryptor stringEncryptor;
    private final PostService postService;


    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(int id) {
        return personRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Kullanici bulunamadi"));
    }

    @Override
    public Person addPerson(Person person) {
        String encryptedPass = stringEncryptor.encrypt(person.getPassword().trim());
        person.setPassword(encryptedPass);
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(int id, Person person) {
        Person existingPerson = personRepository.findById(id).orElseThrow(()-> new RuntimeException("kullanici bulunamadi"));
        existingPerson.setName(person.getName());
        String encryptedPass = stringEncryptor.encrypt(person.getPassword().trim());
        existingPerson.setPassword(encryptedPass);

        return personRepository.save(existingPerson);
    }

    @Override
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    @Override
    public Post addPost(int personId, Post post) {
        Person existingPerson = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        post.setOwner(existingPerson);
        List<Post> posts = existingPerson.getPosts();
        posts.add(post);
        personRepository.save(existingPerson);

        return post;
    }
}
