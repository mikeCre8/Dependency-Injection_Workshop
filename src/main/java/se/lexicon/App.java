package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.models.Student;
import se.lexicon.service.StudentManagement;

public class App
{
    public static void main( String[] args ) {
    
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);
        
        Student student = studentManagement.save(studentManagement.create()); //  David
        // 1 , David
        try {
            System.out.println(studentManagement.edit(studentManagement.editScanner()));
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(studentManagement.findAll());
    }
}
