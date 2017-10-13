package com.org.spring.data.jpa.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.org.spring.data.jpa.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	//Connect to Database
	@PersistenceContext
	EntityManager entityManager;

	//Java Persistence Query Language(JPQL)
	public List<Person> findAll(){
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = this.findById(id);
		entityManager.remove(person);
	}
}
