import java.util.ArrayList;
import java.util.Arrays;

public class Wumpus extends Creature{

    private static int nameCount;
    private Player player;

    public Wumpus(Graph.Node initNode) {
        super(initNode);

        name = String.valueOf(nameCount);
        nameCount++;
    }


    public void move() {
        ArrayList<Graph.Node> neighbors = (ArrayList<Graph.Node>)(currentRoom.getNeighbors().clone());
        for (int i = 0; i < neighbors.size();i++) {
            Graph.Node n = neighbors.get(i);
            if(player.getCurrentRoom().equals(n)){
                neighbors.remove(n);
                i--;
            }
        }


    }

    public String getType() {
        return "Wumpus";
    }

    public void setPlayer(Player player) {
        this.player=player;
    }
}
