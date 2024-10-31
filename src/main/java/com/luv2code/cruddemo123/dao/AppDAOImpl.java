package com.luv2code.cruddemo123.dao;

import com.luv2code.cruddemo123.entity.Instructor;
import com.luv2code.cruddemo123.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDao{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class,theId);

    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class,theId);
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail temp = entityManager.find(InstructorDetail.class,theId);
        temp.getInstructor().setInstructorDetail(null);
        entityManager.remove(temp);
    }
}
