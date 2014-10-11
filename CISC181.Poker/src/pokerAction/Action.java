package pokerAction;

public abstract class Action {

    /** The action's name. */
    private final String name;
    
    /** The action's verb. */
    private final String verb;
    
    public static final Action Deal = new DealAction();
    public static final Action Start = new StartAction();
    public static final Action End = new EndAction();
    
    public Action(String name, String verb) {
        this.name = name;
        this.verb = verb;
    }
    
    public final String getName() {
        return name;
    }
    
    public final String getVerb() {
        return verb;
    }
    
    @Override
    public String toString() {
        return name;
    }
        
}
