import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Player p = new Player("Santa", "hi hello nope bye haha lol");
        Graph g = new Graph();

        initGraph(g);
        p.setCurrentRoom(g.getNode("hall"));
        String response = "";
        Scanner s = new Scanner(System.in);
        g.addCreatures(800, p);

        addItems(g);

        do{
            g.moveChickens();

            System.out.println("You are in the " + p.getCurrentRoom().getName());
            System.out.println("What do you want to do?");

            response = s.nextLine();



            if(response.contains("go")){
                String name = response.substring(response.indexOf(" ")+1);
                if(!p.moveToRoom(name)){
                    System.out.println("That is not a valid name please try again.");
                }
            }

            else if(response.contains("take")) {
                String name = response.substring(response.indexOf(" ") + 1);
                if(p.getCurrentRoom().getItem(name)!=null){
                    p.addItem(p.getCurrentRoom().getItem(name));
                    System.out.println("You took the " + name);
                } else {
                    System.out.println("That item does not exist, please try again");
                }
            }

            else if(response.contains("drop")) {
                String name = response.substring(response.indexOf(" ") + 1);
                Item toDrop = p.removeItem(name);
                if ( toDrop == null) {
                    System.out.println("That item does not exist, please try again");
                } else {
                    p.getCurrentRoom().addItem(toDrop);
                    System.out.println("you dropped item " + name);
                }
            }

            else if(response.equals("look")){

                System.out.println(p.getCurrentRoom().getNeighborNames());
                System.out.println(p.getCurrentRoom().getItems().toString());
                System.out.println(g.getCreaturesInRoom(p.getCurrentRoom()));

            }

            else if(response.contains("add room")){

                String name = response.substring(9);

                if(p.getCurrentRoom().getNeighbor(name)==null){
                    System.out.println("Room added!");
                    g.addNode(name, " ");
                    g.addDirectedEdge(p.getCurrentRoom().getName(),name);
                } else {
                    System.out.println("That room already exists, try again");
                }

            }

            else if(response.equals("quit")){

                System.out.println("Good-bye!");
                return;

            }

            else if(response.contains("inventory")){
                System.out.println(p.getItems().toString());
            }
            else{

                System.out.println("That is not a valid command. Possible commands are:");
                System.out.println("look - see what rooms you can go to, what items you can pick up, what animals are near");
                System.out.println("add room <roomname> - adds a room to the one you are in");
                System.out.println("display inventory - displays what you currently own");
                System.out.println("quit - terminates the program");

            }


        } while (!response.equals("quit"));


    }

    private static void addItems(Graph g) {

        g.getNode("dungeon").addItem(new Item("Knife", ""));
        g.getNode("dungeon").addItem(new Item("Secret Item", ""));
        g.getNode("dungeon").addItem(new Item("Poison", ""));
        g.getNode("dungeon").addItem(new Item("what else do you find in the dungeon help plz", ""));
        g.getNode("dungeon").addItem(new Item("Annoying Orange", ""));

    }

    private static void initGraph(Graph g) {
        g.addNode("hall", "A long dank hallway");
        g.addNode("closet", "Dark darker closet");
        g.addNode("dungeon", "gulags");
        g.addNode("KGB headquarters", "The headquarters of the secret police");

        g.addUndirectedEdge("hall", "dungeon");
        g.addUndirectedEdge("hall", "closet");
        g.addUndirectedEdge("KGB headquarters", "dungeon");
    }


}
