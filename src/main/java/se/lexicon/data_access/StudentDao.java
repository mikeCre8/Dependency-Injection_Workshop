package se.lexicon.data_access;

import se.lexicon.exceptions.DataNotFoundException;
import se.lexicon.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

Student save(Student student);

Optional<Student> find(Integer id);

List<Student> findAll();

void delete(Integer id) throws DataNotFoundException;

}
