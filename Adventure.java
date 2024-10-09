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
        Item item = player.getCurrentRoom().findItem(itemName);
        if (item == null) {
            return "There is nothing like " + itemName + " to take around here.";
        } else {
            player.takeItem(item);
            player.getCurrentRoom().removeItem(item);
            return "You took " + item.getLongName();
        }
    }

    public String dropItem(String itemName) {
        Item item = player.findItemInInventory(itemName);
        if (item == null) {
            return "You don't have anything like " + itemName + " in your inventory.";
        } else {
            player.dropItem(item);
            player.getCurrentRoom().addItem(item);
            return "You dropped " + item.getLongName();
        }
    }

    public String eatItem(String itemName) {
        // Først tjekker vi om maden er i spillerens inventory
        Item item = player.findItemInInventory(itemName);
        if (item == null) {
            // Tjek om maden er i rummet
            item = player.getCurrentRoom().findItem(itemName);
            if (item == null) {
                return "There is nothing like " + itemName + " to eat around here.";
            } else {
                // Hvis mad er i rummet, skal vi først tage det
                player.takeItem(item);
                player.getCurrentRoom().removeItem(item);
            }
        }

        // Hvis objektet ikke er en type Food, skal vi returnere en fejlmeddelelse
        if (!(item instanceof Food)) {
            return "You can't eat " + item.getLongName() + ".";
        }

        // Spis maden og fjern den fra inventory
        Food food = (Food) item;
        player.changeHealth(food.getHealthPoints());
        player.dropItem(item);

        return "You ate " + food.getLongName() + ". " + (food.getHealthPoints() > 0 ? "You feel better!" : "You feel worse...");
    }

    public String showInventory() {
        return player.inventory();
    }
}