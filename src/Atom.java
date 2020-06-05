package src;

public class Atom{
    // Constructors
    public Atom(int c){
        color = c;
    }
    // Methods
    
    public Atom(Atom i) {
        this.color = i.getColor();
    }
    
	// Setters
    public void setColor(int c){
        color = c;
    }

    // Getters
    public int getColor(){
        return color;
    }
    
    // Variables
    private int color;

    /*
     * Access specifiers to be decided? will decide later
    */
}