package src;

import UI.controllerUI;

public class graphic_view extends view {

    public graphic_view(){
        super();
        cUi = new controllerUI(controller.get());
    }

    @Override
    public void render() {
        cUi.render();
    }

    @Override
    public Pair read(int player_id) {
        return cUi.read(player_id);
    }

    @Override
    public void animateAtom(Pair src, Pair dst, Atom a) {
        cUi.animateAtom(src,dst,a);
    }

    private controllerUI cUi;
    
}