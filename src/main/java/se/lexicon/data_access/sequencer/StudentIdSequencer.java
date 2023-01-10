package se.lexicon.data_access.sequencer;

public class StudentIdSequencer {
    
    private static int sequencer = 0;
    
    public static Integer nextId() {
        return ++sequencer;
    }
    
}
