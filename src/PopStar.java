import java.util.ArrayList;

public class PopStar extends Creature{
    private static int nameCount;
    private Player p;
    public PopStar(Graph.Node initNode) {
        super(initNode);

        name = getType() + " " + String.valueOf(nameCount);
        nameCount++;
    }

    @Override
    public void move() {
        ArrayList<Graph.Node> neighbors = currentRoom.getNeighbors();
        for (Graph.Node n: neighbors) {
            if(n.equals(p.getCurrentRoom())){
                currentRoom = p.getCurrentRoom();
                System.out.println(name + " Has entered and is attacking you! ");
                return;
            }
        }

        randomizeRoom();
    }

    @Override
    public String getType() {
        return "PopStar";
    }

    public void setPlayer(Player player) {
        this.p=player;
    }

    public Player getPlayer() {
        return p;
    }
}
