public class InventoryCommand extends Command {
    public InventoryCommand() {
        super("inventory", "displays what things you posses");
    }

    @Override
    public void execute(String message, Player player) {
        System.out.println(player.getItems());
    }
}
