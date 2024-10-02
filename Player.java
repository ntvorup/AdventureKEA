import java.util.ArrayList;

public class Player {
    private Rooms currentRooms;
    private ArrayList<Items> inventory = new ArrayList<>();

    public Player(Rooms startingRooms) {
        this.currentRooms = startingRooms;
    }

    public String move(String direction) {
        Rooms nextRooms = currentRooms.getRoomInDirection(direction);
        if (nextRooms != null) {
            currentRooms = nextRooms;
            return "You go " + direction + ".\n";
        } else {
            return "You can't go that way.";
        }
    }

    public String look() {
        return "You are in " + currentRooms.getName() + ".\n" + currentRooms.getDescription();
    }

    public Rooms getCurrentRoom() {
        return currentRooms;
    }

    public String inventory() {
        if (inventory.isEmpty()) {
            return "Your inventory is empty.";
        } else {
            StringBuilder inv = new StringBuilder("You are carrying: \n");
            for (Items items : inventory) {
                inv.append(items.getLongName()).append(", \n");
            }
            inv.setLength(inv.length() - 2);
            return inv.toString();
        }
    }

    public void takeItem(Items items) {
        inventory.add(items);
    }

    public void dropItem(Items items) {
        inventory.remove(items);
    }

    public Items findItemInInventory(String shortName) {
        for (Items items : inventory) {
            if (items.getShortName().equals(shortName)) {
                return items;
            }
        }
        return null;
    }
}