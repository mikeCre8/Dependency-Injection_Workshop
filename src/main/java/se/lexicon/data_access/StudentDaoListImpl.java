package se.lexicon.data_access;

import org.springframework.stereotype.Repository;
import se.lexicon.data_access.sequencer.StudentIdSequencer;
import se.lexicon.exceptions.DataNotFoundException;
import se.lexicon.models.Student;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoListImpl implements StudentDao{
    
    private List<Student> students = new ArrayList<>();
    
    @Override
    public Student save( Student student ) {
        if(student == null) throw new IllegalArgumentException("student was null");
        int studentId = StudentIdSequencer.nextId();
        student.setId(studentId);
        students.add(student);
        return student;
    }
    
    @Override
    public Student find( int id ) throws DataNotFoundException {
        if(id == 0) throw new IllegalArgumentException("Student id not valid");
        Student student = null;
        for (Student student1 : students){
            if(student1.getId() == id)
                student = student1;
        }
        if(student == null) throw new DataNotFoundException("no data found");
        return student;
    }
    
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }
    
    @Override
    public void delete( int id ) throws DataNotFoundException {
        students.remove(find(id));
    }
}
