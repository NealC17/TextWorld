import java.util.ArrayList;

public abstract class Creature {

    protected String name;
    protected String description;
    protected Graph.Node currentRoom;


    public Creature(Graph.Node initNode){
        currentRoom = initNode;
    }

    public abstract void move(Graph.Node nextRoom);

    public void randomizeRoom(){

        ArrayList<Graph.Node> neighbors= currentRoom.getNeighbors();

        currentRoom = neighbors.get((int)(Math.random()* neighbors.size()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Graph.Node getCurrentRoom(){
        return currentRoom;
    }


}
