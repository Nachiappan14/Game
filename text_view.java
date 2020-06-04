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
    Grid gameGrid;
}