public class LookCommand extends Command {

    private Graph graph;

    public LookCommand() {
        super("look", "Shows neighboring rooms, items and creatures in current room");
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    @Override
    public void execute(String message, Player p) {
        System.out.println(p.getCurrentRoom().getNeighborNames());
        System.out.println(p.getCurrentRoom().getItems().toString());
        System.out.println(graph.getCreaturesInRoom(p.getCurrentRoom()));
    }

    public Graph getGraph() {
        return graph;
    }
}
