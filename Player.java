import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int health;  // Tilføjet
    private Weapon equippedWeapon;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.health = 100;  // Start med 100 health
    }

    public String move(String direction) {
        Room nextRoom = currentRoom.getRoomInDirection(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return "You go " + direction + ".\n";
        } else {
            return "You can't go that way.";
        }
    }

    public String look() {
        return "You are in " + currentRoom.getName() + ".\n" + currentRoom.getDescription();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String inventory() {
        if (inventory.isEmpty()) {
            return "Your inventory is empty.";
        } else {
            StringBuilder inv = new StringBuilder("You are carrying: \n");
            for (Item item : inventory) {
                inv.append(item.getLongName()).append(", \n");
            }
            inv.setLength(inv.length() - 2);
            return inv.toString();
        }
    }

    public void takeItem(Item item) {
        inventory.add(item);
    }

    public void dropItem(Item item) {
        inventory.remove(item);
    }

    public Item findItemInInventory(String shortName) {
        for (Item item : inventory) {
            if (item.getShortName().equals(shortName)) {
                return item;
            }
        }
        return null;
    }

    public int getHealth() {
        return health;
    }

    public void changeHealth(int amount) {
        this.health += amount;
        if (this.health > 100) {
            this.health = 100;  // Maksimum health
        } else if (this.health < 0) {
            this.health = 0;  // Minimum health
        }
    }

    public String healthStatus() {
        String status = "You are in good health.";
        if (health >= 70) {
            status = "You are in great shape!";
        } else if (health >= 40) {
            status = "You are in decent health, but be cautious.";
        } else if (health >= 20) {
            status = "You are weak, try to find something to eat.";
        } else if (health > 0) {
            status = "You are in critical condition!";
        } else {
            status = "You are dead.";
        }
        return "Health: " + health + " - " + status;
    }
    public void equipWeapon(Weapon weapon) {
        if (inventory.contains(weapon) && weapon instanceof Weapon) {
            this.equippedWeapon = weapon;
            System.out.println("You equipped the " + weapon.getLongName() + ".");
        } else if (!inventory.contains(weapon)) {
            System.out.println("You don't have that weapon.");
        } else {
            System.out.println(weapon.getLongName() + " is not a weapon.");
        }
    }

    public void attack() {
        if (equippedWeapon == null) {
            System.out.println("You have no weapon equipped!");
        } else {
            equippedWeapon.use();
        }
    }
}
