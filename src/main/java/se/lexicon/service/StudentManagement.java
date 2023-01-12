package se.lexicon.service;

import se.lexicon.exceptions.DataNotFoundException;
import se.lexicon.models.Student;
import java.util.List;

public interface StudentManagement {
    
    Student create();
    
    Student editScanner();
    
    
    Student save(Student student);
    
    Student find(int id) throws DataNotFoundException;
    
    Student remove(int id) throws DataNotFoundException;
    
    List<Student> findAll();
    
    Student edit(Student student) throws DataNotFoundException;
    
    
}
