import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int health;
    private Weapon equippedWeapon;
    private boolean hasMap = false;  // tracking if the player has the ancient map

    // List of artifact items required to satisfy the statue
    private ArrayList<String> requiredArtifacts = new ArrayList<>(Arrays.asList("Mysterious Amulet", "Silver Mirror", "Ancient Scroll", "Hourglass of Time", "Tome of Forgotten Knowledge"));

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.health = 100;
    }

    public boolean hasAllArtifacts() {
        for (String artifactName : requiredArtifacts) {
            boolean found = false;
            for (Item item : inventory) {
                if (item.getLongName().equalsIgnoreCase(artifactName)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;  // Player is missing one or more artifacts
            }
        }
        return true;  // Player has all artifacts
    }

    public String move(String direction) {
        // Check if there are enemies in the room before allowing the player to leave
        if (!currentRoom.getEnemies().isEmpty()) {
            return "You can't leave the room while there are enemies!";
        }

        Room nextRoom = currentRoom.getRoomInDirection(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return "You go " + direction + ".\n";
        } else {
            return "You can't go that way.";
        }
    }

    public String look() {
        String roomDetails = currentRoom.getRoomDetails(this);  // Pass player instance for artifact checks
        String exits = showExits();  // Show exits if the player has the map
        return roomDetails + (exits.isEmpty() ? "" : "\n" + exits);  // Add exits if applicable
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    // Show the player's inventory
    public String inventory() {
        if (inventory.isEmpty()) {
            return "Your inventory is empty.";
        } else {
            StringBuilder inv = new StringBuilder("You are carrying:\n");
            for (Item item : inventory) {
                inv.append("- ").append(item.getLongName()).append("\n");
            }
            return inv.toString();
        }
    }

    public String takeItem(String itemName) {
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            inventory.add(item);
            currentRoom.removeItem(item);
            if (item.getShortName().equalsIgnoreCase("map")) {
                hasMap = true;
                return "You picked up: " + item.getLongName() + ". Now you can see the possible exits.";
            }
            return "You picked up: " + item.getLongName();
        }
        return "There is no item by that name here.";
    }

    public String dropItem(String itemName) {
        Item item = findItemInInventory(itemName);
        if (item != null) {
            inventory.remove(item);
            currentRoom.addItem(item);
            return "You dropped: " + item.getLongName();
        }
        return "You don't have that item.";
    }

    public String equipWeapon(String weaponName) {
        Item item = findItemInInventory(weaponName);
        if (item instanceof Weapon) {
            equippedWeapon = (Weapon) item;
            enemiesAttack();
            return "You equipped: " + equippedWeapon.getLongName();
        }
        return "You can't equip that.";
    }

    public Item findItemInInventory(String shortName) {
        for (Item item : inventory) {
            if (item.getShortName().equals(shortName)) {
                return item;
            }
        }
        return null;
    }

    public String attackEnemy(String enemyName) {
        Enemy enemy = currentRoom.findEnemy(enemyName);
        if (enemy == null) {
            return "There is no enemy by that name here.";
        }

        if (equippedWeapon != null && equippedWeapon.canUse()) {
            equippedWeapon.use();
            enemy.takeDamage(equippedWeapon.getDamage());
            if (!enemy.isAlive()) {
                currentRoom.removeEnemy(enemy);
                return enemy.getName() + " is defeated.";
            }
            enemiesAttack();
            return "";
        }
        return "You don't have a weapon equipped or can't use your weapon!";
    }

    public String eatFood(String foodName) {
        Item item = findItemInInventory(foodName);
        if (item instanceof Food) {
            Food food = (Food) item;
            changeHealth(food.getHealthPoints());  // Restore health
            inventory.remove(item);  // Remove the food after eating
            return "You ate the " + food.getLongName() + ". It restored " + food.getHealthPoints() + " health!";
        }
        return "You can't eat that.";
    }

    public void changeHealth(int amount) {
        health = Math.max(0, Math.min(100, health + amount));  // Health range between 0 and 100
    }

    public int getHealth() {
        return health;
    }

    public void enemiesAttack() {
        for (Enemy enemy : currentRoom.getEnemies()) {
            enemy.attack(this);  // Each enemy attacks the player
        }
    }

    public String showExits() {
        if (hasMap) {
            String exitsDescription = currentRoom.getExitsDescription();
            if (exitsDescription.isEmpty()) {
                return "There are no exits.";
            }
            return "You can go: " + exitsDescription;
        }
        return "";
    }
}