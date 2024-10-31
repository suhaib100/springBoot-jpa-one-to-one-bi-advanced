package com.luv2code.cruddemo123.dao;

import com.luv2code.cruddemo123.entity.Instructor;
import com.luv2code.cruddemo123.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);



}
