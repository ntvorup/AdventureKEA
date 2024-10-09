import java.util.Scanner;

public class UI {
    private Adventure adventure;

    public UI(Adventure adventure) {
        this.adventure = adventure;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to The Lost Word of the Forgotten Temple!");
        System.out.println();
        System.out.println("Type 'help' for a list of commands.");
        System.out.println();

        boolean playing = true;
        while (playing) {
            System.out.print("> ");
            String input = scanner.nextLine().toLowerCase().trim();

            if (input.equals("take")) {
                System.out.println("Take what?");
            } else if (input.startsWith("take ")) {
                String itemName = input.substring(5).trim();
                System.out.println(adventure.takeItem(itemName.isEmpty() ? "" : itemName));
            } else if (input.equals("drop")) {
                System.out.println("Drop what?");
            } else if (input.startsWith("drop ")) {
                String itemName = input.substring(5).trim();
                System.out.println(adventure.dropItem(itemName.isEmpty() ? "" : itemName));
            } else if (input.equals("eat")) {
                System.out.println("Eat what?");
            } else if (input.startsWith("eat ")) {
                String foodName = input.substring(4).trim();
                System.out.println(adventure.eatItem(foodName.isEmpty() ? "" : foodName));
            } else if (input.startsWith("equip ")) {
                String weaponName = input.substring(6).trim();
                Weapon weapon = (Weapon) adventure.getPlayer().findItemInInventory(weaponName);
                adventure.getPlayer().equipWeapon(weapon);
            } else if (input.equals("attack")) {
                adventure.getPlayer().attack();
            } else {
                switch (input) {
                    case "go north":
                    case "north":
                    case "n":
                    case "go east":
                    case "east":
                    case "e":
                    case "go south":
                    case "south":
                    case "s":
                    case "go west":
                    case "west":
                    case "w":
                        System.out.println(adventure.movePlayer(input));
                        break;
                    case "look":
                        System.out.println(adventure.lookAround());
                        break;
                    case "help":
                        printHelp();
                        break;
                    case "exit":
                        System.out.println("Exiting the game. Thank you for playing!");
                        playing = false;
                        break;
                    case "inventory":
                    case "show inventory":
                        System.out.println(adventure.showInventory());
                        break;
                    case "health":
                        System.out.println("Your health: " + adventure.getPlayer().getHealth());
                        break;
                    default:
                        System.out.println("Invalid command. Type 'help' for a list of commands.");
                        break;
                }
            }
        }
        scanner.close();
    }

    private void printHelp() {
        System.out.println("Available commands:");
        System.out.println("go 'north, east, south or west' - Move in a specific direction");
        System.out.println("look - Look around the current room");
        System.out.println("take 'item' - Pick up an item");
        System.out.println("drop 'item' - Drop an item");
        System.out.println("inventory - Show your current inventory");
        System.out.println("eat 'food' - Eat an item of food");
        System.out.println("equip 'weapon' - Equip a weapon from your inventory");
        System.out.println("attack - Attack the empty air");
        System.out.println("health - Show your current health");
        System.out.println("help - Display this help message");
        System.out.println("exit - Exit the game");
    }
}