package se.lexicon.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.data_access.sequencer.StudentIdSequencer;
import se.lexicon.exceptions.DataNotFoundException;
import se.lexicon.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StudentDaoListImpl implements StudentDao{
    
    private List<Student> students = new ArrayList<>();
    
    @Override
    public Student save( Student student ) {
        if(student == null) throw new IllegalArgumentException("customer was null");
        int studentId = StudentIdSequencer.nextId();
        student.setId(studentId);
        students.add(student);
        return student;
    }
    
    @Override
    public Optional<Student> find( Integer id ) {
        if(id == null) throw new IllegalArgumentException("Student id was null");
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }
    
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }
    
    @Override
    public void delete( Integer id ) throws DataNotFoundException {
        Optional<Student> optionalStudent = find(id);
        if(!optionalStudent.isPresent()) throw new DataNotFoundException("data not found");
        else students.remove(optionalStudent.get());
    
    }
}
