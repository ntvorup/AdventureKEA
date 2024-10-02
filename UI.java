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
                if (!itemName.isEmpty()) {
                    System.out.println(adventure.takeItem(itemName));
                } else {
                    System.out.println("Take what?");
                }
            } else if (input.equals("drop")) {
                System.out.println("Drop what?");
            } else if (input.startsWith("drop ")) {
                String itemName = input.substring(5).trim();
                if (!itemName.isEmpty()) {
                    System.out.println(adventure.dropItem(itemName));
                } else {
                    System.out.println("Drop what?");
                }
            } else {
                switch (input) {
                    case "north":
                    case "n":
                        System.out.println(adventure.movePlayer("north"));
                        break;
                    case "east":
                    case "e":
                        System.out.println(adventure.movePlayer("east"));
                        break;
                    case "south":
                    case "s":
                        System.out.println(adventure.movePlayer("south"));
                        break;
                    case "west":
                    case "w":
                        System.out.println(adventure.movePlayer("west"));
                        break;
                    case "find letter":
                        findLetter();
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
                    default:
                        System.out.println("Invalid command. Type 'help' for a list of commands.");
                        break;
                }
            }
        }
        scanner.close();
    }

    private void findLetter() {
        Rooms currentRooms = adventure.getPlayer().getCurrentRoom();
        currentRooms.findLetter();
        System.out.println("You found a letter in this room!");
    }

    private void printHelp() {
        System.out.println("Available commands:");
        System.out.println("go 'north, east, south or west' - Move in a specific direction");
        System.out.println("look - Look around the current room");
        System.out.println("take 'item' - Pick up an item");
        System.out.println("drop 'item' - Drop an item");
        System.out.println("inventory - Show your current inventory");
        System.out.println("help - Display this help message");
        System.out.println("exit - Exit the game");
    }
}