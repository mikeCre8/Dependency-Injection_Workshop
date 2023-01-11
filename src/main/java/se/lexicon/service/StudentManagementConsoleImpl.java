package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.ConsoleColors;
import se.lexicon.data_access.StudentDao;
import se.lexicon.exceptions.DataNotFoundException;
import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;
import java.util.List;

@Service
public class StudentManagementConsoleImpl implements StudentManagement{
    
    UserInputService scannerService;
    StudentDao studentDao;
    
    @Autowired
    public StudentManagementConsoleImpl( UserInputService scannerService, StudentDao studentDao ) {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
    }
    
    @Override
    public Student create() {
        return new Student(scannerService.getString());
    }
    
    @Override
    public Student save( Student student ) {
        if(student == null) throw new IllegalArgumentException("student was null");
        studentDao.save(student);
        System.out.println(ConsoleColors.GREEN + "Student " + student.getName()+" with ID "+student.getId() + " stored!");
        System.out.println(ConsoleColors.RESET);
        return student;
    }
    
    @Override
    public Student find( int id ) throws DataNotFoundException {
        studentDao.find(scannerService.getId());
        return studentDao.find(id);
    }
    
    @Override
    public Student remove( int id ) throws DataNotFoundException {
        studentDao.delete(scannerService.getId());
        System.out.println("Student removed!");
        return null;
    }
    
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
    
    @Override
    public Student edit( Student student ) throws DataNotFoundException {
        if(student == null) throw new IllegalArgumentException("student was null");
        studentDao.find(scannerService.getId());
        
        return student;
    }
}
