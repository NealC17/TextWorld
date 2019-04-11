public class DropCommand extends Command {
    public DropCommand() {
        super("drop", "drops item");
    }

    @Override
    public void execute(String response, Player p) {
        String name = super.extractRoomOrItemName(response);
                Item toDrop = p.removeItem(name);
                if ( toDrop == null) {
                    System.out.println("That item does not exist, please try again");
                } else {
                    p.getCurrentRoom().addItem(toDrop);
                   System.out.println("You dropped item " + name);
                }
    }
}
