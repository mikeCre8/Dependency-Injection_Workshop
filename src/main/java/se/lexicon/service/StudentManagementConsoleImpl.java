package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.data_access.StudentDao;
import se.lexicon.data_access.sequencer.StudentIdSequencer;
import se.lexicon.exceptions.DataNotFoundException;
import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentManagementConsoleImpl implements StudentManagement{
    
    UserInputService scannerService;
    StudentDao studentDao;
    
    List<Student> students;
    Student student;
    
    public StudentManagementConsoleImpl() {
    }
    
    @Autowired
    public StudentManagementConsoleImpl( UserInputService scannerService, StudentDao studentDao ) {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
    }
    
    @Override
    public Student create() {
        return save(new Student(scannerService.getString()));
    }
    
    @Override
    public Student save( Student student ) {
        if(student == null) throw new IllegalArgumentException("student was null");
        Integer studentId = StudentIdSequencer.nextId();
//        student.setName(scannerService.getString());
        student.setId(studentId);
        students.add(student);
        
        return student;
    }
    
    @Override
    public Optional<Student> find( Integer id ) {
        if(id == null) throw new IllegalArgumentException("Student id was null");
        return students.stream()
                .filter(student -> student.getId().equals(scannerService.getId()))
                .findFirst();
    }
    
    @Override
    public Student remove( Integer id ) throws DataNotFoundException {
        Optional<Student> optionalStudent = find(id);
        if(!optionalStudent.isPresent()) throw new DataNotFoundException("data not found");
        else students.remove(optionalStudent.get());
        return null;
    }
    
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }
    
    @Override
    public Student edit( Student student ) {
        if(student == null) throw new IllegalArgumentException("student was null");
        scannerService.getId();
        students.set(student.getId(), student);
        return student;
    }
}
