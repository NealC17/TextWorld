public class Chicken extends Creature{


    public Chicken(Graph.Node initNode) {
        super(initNode);
    }

    public Chicken(String name) {
        super(null);
        this.name = name;
    }

    @Override
    public void move(Graph.Node nextRoom) {
        currentRoom = nextRoom;
    }



}
