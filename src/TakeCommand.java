public class TakeCommand extends Command{

    public TakeCommand() {
        super("take", "Takes an item");
    }

    @Override
    public void execute(String message, Player player) {
        String itemName = super.extractRoomOrItemName(message);
        Graph.Node currentNode = player.getCurrentRoom();
        Item item = currentNode.getItem(itemName);

        if(item != null){
            player.addItem(item);
            System.out.println("You took " + itemName);
        } else {
            System.out.println("That item does not exist. Try Again.");
        }

    }

}
