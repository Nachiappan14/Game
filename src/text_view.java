package src;

import java.util.Scanner;

public class text_view extends view{
    public text_view(){
        super();
    }
    @Override
    public void render(){
        System.out.println("OwnerOfCell\t\t\tNumber of Atoms");
        for(Cell[] i:gameGrid.cellList){
            for(Cell j:i)
                System.out.print(j.currentOwner()+" ");
            System.out.print("\t\t\t");
            for(Cell j:i)
                System.out.print(j.atomCount()+" ");
            System.out.print("\n");
        }
    }
    
    @Override
    public Pair read(int Player_id){
        String ipt = cin.nextLine();
        String[] tokens = ipt.split("[()<>{} ,]+",0);
        if(ipt.charAt(0)!='(')
            return new Pair(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        return new Pair(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
    }

    @Override
    public void animateAtom(Pair src, Pair dst, Atom a) {
        // No animation required in the text view
    }

    private Scanner cin = new Scanner(System.in);
    Grid gameGrid = controller.get().gameGrid;
}