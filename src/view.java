package src;

public abstract class view {
    public abstract void render();
    public abstract Pair read(int player_id);
	public abstract void animateAtom(Pair src,Pair dst,Atom a);
}