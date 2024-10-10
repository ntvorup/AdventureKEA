import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private String name;
    private String description;
    private String revisitedDescription;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;  // List of items in the room
    private ArrayList<Enemy> enemies;  // List of enemies in the room
    private boolean hasSadStatue = false;

    public Room(String name, String description, String revisitedDescription) {
        this.name = name;
        this.description = description;
        this.revisitedDescription = revisitedDescription;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();  // Initialize items
        this.enemies = new ArrayList<>();  // Initialize enemies
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Room getRoomInDirection(String direction) {
        return exits.get(direction);
    }

    public String getName() {
        return name;
    }

    public String getRoomDescription() {
        StringBuilder details = new StringBuilder();
        details.append(description).append("\n");

        if (!items.isEmpty()) {
            details.append("You see the following items:\n");
            for (Item item : items) {
                details.append("- ").append(item.getLongName()).append("\n");
            }
        }

        if (!enemies.isEmpty()) {
            details.append("You see the following enemies:\n");
            for (Enemy enemy : enemies) {
                details.append("- ").append(enemy.getName()).append("\n");
            }
        }

        return details.toString();
    }

    public String getRevisitedDescription() {
        return revisitedDescription;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public Enemy findEnemy(String enemyName) {
        for (Enemy enemy : enemies) {
            if (enemy.getName().toLowerCase().contains(enemyName.toLowerCase())) {
                return enemy;
            }
        }
        return null;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    public String getRoomDetails(Player player) {
        StringBuilder details = new StringBuilder();
        details.append(description).append("\n");

        if (!items.isEmpty()) {
            details.append("You see the following items:\n");
            for (Item item : items) {
                details.append("- ").append(item.getLongName()).append("\n");
            }
        }

        if (!enemies.isEmpty()) {
            details.append("You see the following enemies:\n");
            for (Enemy enemy : enemies) {
                details.append("- ").append(enemy.getName()).append("\n");
            }
        }

        if (hasSadStatue) {
            if (player.hasAllArtifacts()) {
                details.append("You completed the quest and is rewarded 1 million beers! Feel free to roam the temple, or exit my temple, by typing 'exit'.\n");
            } else {
                details.append("The statue looks sad. It seems to be missing important artifacts.\n");
            }
        }
        return details.toString();
    }

    public String getExitsDescription() {
        if (exits.isEmpty()) {
            return "";  // No exits
        }
        return String.join(" & ", exits.keySet());
    }

    public void setHasSadStatue(boolean hasSadStatue) {
        this.hasSadStatue = hasSadStatue;
    }
}