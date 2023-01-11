package se.lexicon.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ScannerInputService implements UserInputService{
    
    public ScannerInputService() {
    }
    
    Scanner scanner;
    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }
    
        @Override
        public String getString() {
            System.out.print("Enter student name: ");
        return scanner.nextLine();
    }
        
        @Override
        public Integer getId() {
            System.out.print("Enter student ID: ");
        return scanner.nextInt();
    }
}
