package se.lexicon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ScannerInputService implements UserInputService{
    
    @Autowired
    private Scanner scanner;
    @Autowired
    public ScannerInputService() {
    }
    
    @Override
    public String getString() {
        return scanner.nextLine();
    }
    
    @Override
    public Integer getId() {
        return scanner.nextInt();
    }
}
