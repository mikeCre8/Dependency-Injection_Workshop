package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.models.Student;

public class App
{
    public static void main( String[] args ) {
    
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
    
        StudentDao studentDao = context.getBean(StudentDao.class);
        System.out.println(studentDao.save(new Student("John Doe")));
    }
}
