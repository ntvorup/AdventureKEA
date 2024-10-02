public class Adventure {
    private Player player;
    private Map map;

    public Adventure(Map map) {
        this.map = map;
        this.player = new Player(map.getStartRoom());
    }

    public String movePlayer(String direction) {
        return player.move(direction);
    }

    public String lookAround() {
        return player.look();
    }

    public Player getPlayer() {
        return player;
    }

    public String takeItem(String itemName) {
        Items items = player.getCurrentRoom().findItem(itemName);
        if (items == null) {
            return "There is nothing like " + itemName + " to take around here.";
        } else {
            player.takeItem(items);
            player.getCurrentRoom().removeItem(items);
            return "You took " + items.getLongName();
        }
    }

    public String dropItem(String itemName) {
        Items items = player.findItemInInventory(itemName);
        if (items == null) {
            return "You don't have anything like " + itemName + " in your inventory.";
        } else {
            player.dropItem(items);
            player.getCurrentRoom().addItem(items);
            return "You dropped " + items.getLongName();
        }
    }

    public String showInventory() {
        return player.inventory();
    }

}