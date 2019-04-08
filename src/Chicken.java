import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;

public class Chicken extends Creature{


    private static int nameCount;
    public Chicken(Graph.Node initNode) {
        super(initNode);
        name = String.valueOf(nameCount);
        nameCount++;

    }

    public Chicken(String name) {
        super(null);
        this.name = name;
    }


    public void move() {
        randomizeRoom();
    }

    @Override
    public String getType() {
        return "Chicken";
    }


}
