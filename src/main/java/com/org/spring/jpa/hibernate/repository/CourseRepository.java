package com.org.spring.jpa.hibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.org.spring.jpa.hibernate.model.Course;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	public Course save(Course course) {

		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}

		return course;
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}

	public void playWithEntityManager() {

		Course course1 = new Course("Web Services in 100 Steps");

		em.persist(course1);

		Course course2 = new Course("Angular Js in 100 Steps");

		em.persist(course2);

		em.flush();

		course1.setName("Web Services in 100 Steps - Updated");

		course2.setName("Angular Js in 100 Steps - Updated");

		em.refresh(course1);

		em.flush();
	}
}
