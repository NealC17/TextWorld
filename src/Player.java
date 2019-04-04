import java.util.ArrayList;

public class Player {
    Graph.Node currentNode;

    String name, description;// fields
    ArrayList<Item> items;

    public Player(String name, String description) {
        this.name=name;
        this.description=description;
        items = new ArrayList<>();
    }

    // constructor
    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(String name){
        for(Item i : items){
            if(i.getName().equals(name)){
                items.remove(i);
                return i;
            }
        }

        return null;
    }

    public boolean destroyItem(String name) {
        for(Item i: items){
            if(i.getName().equals(name)){
                items.remove(i);
                return true;
            }
        }
        return false;
    }


    public ArrayList<Item> getItems() {
        return items;
    }

    public void displayInventory() {
        System.out.println("Inventory: " + items.toString());
    }// display items you’re carrying

    public Graph.Node getCurrentRoom() {
        return currentNode;
    }

    public void setCurrentRoom(Graph.Node newroom) {
        currentNode = newroom;
    }// set player’s current room to a new room

    public boolean moveToRoom(String name) {
        System.out.println(name);
        if(currentNode.getNeighborNames().contains(name)){
            currentNode = currentNode.getNeighbor(name);
            return true;
        }
        return false;
    }// try and move to neighboring room with given name


}
