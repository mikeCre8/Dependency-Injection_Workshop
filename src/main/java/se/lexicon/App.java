package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.util.UserInputService;

public class App
{
    public static void main( String[] args ) {
    
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
    
        // Student data access
        /*StudentDao studentDao = context.getBean(StudentDao.class);
        System.out.println(studentDao.save(new Student("John Doe")));*/
    
        // Scanner service
        UserInputService userInputService = context.getBean(UserInputService.class);
        System.out.print("Enter a name: ");
        userInputService.getString();
        System.out.print("Enter student id: ");
        userInputService.getId();
    }
}
