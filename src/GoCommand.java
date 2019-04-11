import java.lang.reflect.Array;
import java.util.ArrayList;

public class GoCommand extends Command{
    public GoCommand() {
        super("go", "goes to a room");
    }

    @Override
    public void execute(String message, Player player) {
        String roomName= super.extractRoomOrItemName(message);
        Graph.Node currentRoom = player.getCurrentRoom();

        if(currentRoom.isNeighboring(roomName)){
            player.moveToRoom(roomName);
            System.out.println("You moved to the " + roomName + "!");
        } else {
            System.out.println("That room does not exist, or you are not neighboring that room. Please try again");
        }


    }
}
