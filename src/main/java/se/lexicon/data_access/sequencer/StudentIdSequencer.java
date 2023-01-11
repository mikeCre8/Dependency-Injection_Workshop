package se.lexicon.data_access.sequencer;

public class StudentIdSequencer {
    
    private static Integer sequencer = 0;
    
    public static Integer nextId() {
        return ++sequencer;
    }
    
}
