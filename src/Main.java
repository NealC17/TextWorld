import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static HashMap<String, Command> commands = new HashMap<>();


    public static void main(String[] args) {
        Player p = new Player("Santa", "hi hello nope bye haha lol");
        Graph g = new Graph();
        initGraph(g);
        initCommands(g);
        addItems(g);


        p.setCurrentRoom(g.getNode("hall"));
        String response = "";
        Scanner s = new Scanner(System.in);
        g.addCreatures(10, p);

        do{
            g.move();

            System.out.println("You are in the " + p.getCurrentRoom().getName());
            System.out.println("What do you want to do?");

            response = s.nextLine();
            String[] tokens = response.split(" ");
            Command toExecute = commands.get(tokens[0]);
            if(toExecute!=null){
                toExecute.execute(response, p);
            } else {
                System.out.println("That is not a valid command. The commands are:");
                for(Command c: commands.values()){
                    System.out.println(c);
                }
            }


        } while (!response.equals("quit"));


    }

    private static void initCommands(Graph g) {
        commands.put("take", new TakeCommand());
        commands.put("go", new GoCommand());
        commands.put("drop", new DropCommand());


        LookCommand look = new LookCommand();
        look.setGraph(g);
        commands.put("look", look);

        AddRoomCommand addRoomCommand = new AddRoomCommand();
        addRoomCommand.setGraph(g);
        commands.put("addRoom", addRoomCommand);

        commands.put("inventory", new InventoryCommand());
        commands.put("quit", new QuitCommand());
    }

    private static void addItems(Graph g) {

        g.getNode("hall").addItem(new Item("Knife", ""));
        g.getNode("dungeon").addItem(new Item("Secret Item", ""));
        g.getNode("dungeon").addItem(new Item("Poison", ""));
        g.getNode("dungeon").addItem(new Item("what else do you find in the dungeon help plz", ""));
        g.getNode("dungeon").addItem(new Item("Annoying Orange", ""));

    }

    private static void initGraph(Graph g) {
        g.addNode("hall", "A long dank hallway");
        g.addNode("closet", "Dark darker closet");
        g.addUndirectedEdge("hall", "closet");

        g.addNode("dungeon", "gulags");
        g.addUndirectedEdge("hall", "dungeon");


        g.addNode("KGB headquarters", "The headquarters of the secret police");
        g.addUndirectedEdge("KGB headquarters", "dungeon");

        g.addNode("bathroom", "du-du");
        g.addDirectedEdge("bathroom", "closet");
        g.addUndirectedEdge("bathroom", "dungeon");

        g.addNode("The void", "eternal darkness");
        g.addDirectedEdge("bathroom", "The Void");

    }


}
