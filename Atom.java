public class Atom{
    // Constructors
    public Atom(){
        // TODO: the method of the construction to be decided
    }
    public Atom(int c){
        color = c;
    }
    // Methods
    public void split(){
        // TODO: A Method to split the atoms to the nearby grid-Cells
        // this one is to be shifted to the cell
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
     * AnyMore variables , Methods required ? No
     * AnyMore constructors required ? No
     * Access specifiers to be decided? will decide later
    */
}