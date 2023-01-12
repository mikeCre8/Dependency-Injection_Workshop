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
            System.out.print("Input: ");
        return scanner.nextLine();
    }
        
        @Override
        public int getInt() {
            System.out.print("Input: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
