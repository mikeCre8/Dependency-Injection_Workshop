package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.data_access.StudentDao;
import se.lexicon.data_access.StudentDaoListImpl;
import se.lexicon.service.StudentManagement;
import se.lexicon.service.StudentManagementConsoleImpl;
import se.lexicon.util.ScannerInputService;
import se.lexicon.util.UserInputService;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "se.lexicon")
public class ComponentScanConfig {

    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }
    
}
