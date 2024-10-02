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
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "go north":
                case "north":
                case "n":
                    System.out.println(adventure.movePlayer("north"));
                    break;
                case "go east":
                case "east":
                case "e":
                    System.out.println(adventure.movePlayer("east"));
                    break;
                case "go south":
                case "south":
                case "s":
                    System.out.println(adventure.movePlayer("south"));
                    break;
                case "go west":
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
                case "take":
                    System.out.println("Take what?");
                    break;
                case "take torch": // ændre til mere overskuelig
                    System.out.println(adventure.takeItem("torch"));
                    break;
                case "take book":
                    System.out.println(adventure.takeItem("book"));
                    break;
                case "take chalice":
                    System.out.println(adventure.takeItem("chalice"));
                case "take amulet":
                    System.out.println(adventure.takeItem("amulet"));
                    break;
                case "drop torch":
                    System.out.println(adventure.dropItem("torch"));
                    break;
                case "drop book":
                    System.out.println(adventure.dropItem("book"));
                    break;
                case "drop chalice":
                    System.out.println(adventure.dropItem("chalice"));
                    break;
                case "drop amulet":
                    System.out.println(adventure.dropItem("amulet"));
                    break;
                case "inventory":
                case "show inventory":
                    System.out.println(adventure.showInventory());
                    break;
                default:
                    System.out.println("Invalid command. Type 'help' for a list of commands.");
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
        System.out.println("go 'north, east, south or west' - Which direction you would like to go");
        //System.out.println("find letter - Look for letters in the room");
        System.out.println("look - Look around the current room");
        System.out.println("take 'item' - Pick up the item of your choosing");
        System.out.println("drop 'item' - Drop the item of your choosing");
        System.out.println("complete 'item' - Combine two item halves if you have both");
        System.out.println("inventory - Show your current inventory");
        System.out.println("help - Display this help message");
        System.out.println("exit - Exit the game");
        //System.out.println("alohomora - Opens the final chamber");
    }
}