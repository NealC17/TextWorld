public class AddRoomCommand extends Command {
    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    private Graph graph;

    public AddRoomCommand() {
        super("addRoom", "adds a room");
    }

    @Override
    public void execute(String message, Player player) {
        String name = super.extractRoomOrItemName(message);
        System.out.println(name);
        if (player.getCurrentRoom().getNeighbor(name) == null) {
            System.out.println("Room added!");
            graph.addNode(name, " ");
            graph.addDirectedEdge(player.getCurrentRoom().getName(), name);
        } else {
            System.out.println("That room already exists, try again");
        }
    }
}
