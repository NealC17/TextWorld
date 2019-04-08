import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private HashMap<String, Node> nodes;
    private ArrayList<Item> items;
    private ArrayList<Creature> creatures;

    public Graph(){

        nodes = new HashMap<>();

        creatures = new ArrayList<>();
    }

    public void addNode(String name, String description) {
        nodes.put(name, new Node(name, description));
    }

    public void addDirectedEdge(String name1, String name2) {
        getNode(name1).addNeighbor(getNode(name2));
        getNode(name2).addNeighbor(getNode(name1));
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public boolean removeCreature(Creature c){
        return creatures.remove(c);
    }


    public void addUndirectedEdge(String name1, String name2) {
        getNode(name1).addNeighbor(getNode(name2));
    }

    public void moveChickens() {
        for (Creature c: creatures){
            c.randomizeRoom();
        }
    }

    public List<Creature> getCreaturesInRoom(Node currentRoom) {
        List<Creature> crea= new ArrayList<>();
        for(Creature c: creatures){
            if(c.getCurrentRoom().equals(currentRoom)){
                crea.add(c);
            }
        }



        return crea;
    }

    public void addChickens(int num) {
        for (int i = 0; i < num; i++) {
            creatures.add(new Chicken(getRandomRoom()));
        }
    }

    public void addWumpuses(int num, Player player) {
        for (int i = 0; i < num; i++) {
            Wumpus toAdd = new Wumpus(getRandomRoom());
            toAdd.setPlayer(player);
            creatures.add(toAdd);
        }
    }

    public void addCreatures(int num, Player player) {
        for (int i = 0; i < num; i++) {
            double rand = Math.random();
            if(rand < 0.33) addChickens(1);
            else if(rand < 0.66) addWumpuses(1, player);
        }
    }

    private Node getRandomRoom() {
        ArrayList<Node> rooms = new ArrayList<>(nodes.values());

        return rooms.get((int)(rooms.size()*Math.random()));
    }


    public class Node {

        private String description;
        private String name;
        private ArrayList<Node> neighbors;
        private ArrayList<Item> items;

        private Node(String name){
            this(name, " ");
        }

        private Node(String name, String description) {
            neighbors = new ArrayList<>();
            this.name = name;
            this.description=description;
            items = new ArrayList<>();
        }


        public void addItem(Item i){
            items.add(i);
        }



        public Item removeItem(String name){
            for(Item i: items){
                if(i.getName().equals(name)){
                    Item temp = i;
                    items.remove(i);
                    return temp;
                }
            }
            return null;
        }

        public ArrayList<Item> getItems(){
            return items;
        }

        public Item getItem(String name){
            for(Item n: items){
                if(n.getName().equals(name)){
                    return n;
                }
            }
            return null;
        }

        private void addNeighbor(Node n){
            neighbors.add(n);
            if(!n.neighbors.contains(this)){
                n.neighbors.add(this);
            }
        }


        public String getName(){
            return name;
        }
        public String getDescription(){
            return description;
        }

        public String getNeighborNames(){
            return neighbors.toString().replace("[","").replace("]","");
        }

        public String toString(){
            return name;
        }

        public Node getNeighbor(String name){
            for(Node n: neighbors){
                if(n.getName().equals(name)){
                    return n;
                }
            }
            return null;
        }

        public ArrayList<Node> getNeighbors() {
            return neighbors;
        }
    }

}
