package se.lexicon.data_access;

import se.lexicon.exceptions.DataNotFoundException;
import se.lexicon.models.Student;
import java.util.List;

public interface StudentDao {

Student save(Student student);

Student find(int id) throws DataNotFoundException;

List<Student> findAll();

void delete(int id) throws DataNotFoundException;

}
