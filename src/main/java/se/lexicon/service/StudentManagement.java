package se.lexicon.service;

import se.lexicon.exceptions.DataNotFoundException;
import se.lexicon.models.Student;
import java.util.List;
import java.util.Optional;

public interface StudentManagement {
    
    Student create();
    
    Student save(Student student);
    
    Optional<Student> find(Integer id);
    
    Student remove(Integer id) throws DataNotFoundException;
    
    List<Student> findAll();
    
    Student edit(Student student);
    
    
}
