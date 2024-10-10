import java.util.HashMap;
import java.util.Scanner;

public class UI {
    private Adventure adventure;
    private Scanner scanner;
    private HashMap<String, Runnable> commands;
    private boolean playing;

    public UI(Adventure adventure) {
        this.adventure = adventure;
        this.scanner = new Scanner(System.in);
        this.commands = new HashMap<>();
        this.playing = true;
        setupCommands();
    }

    private void setupCommands() {
        commands.put("look", () -> System.out.println(adventure.look()));
        commands.put("inventory", () -> System.out.println(adventure.showInventory()));
        commands.put("health", () -> System.out.println("Your health: " + adventure.getPlayer().getHealth()));
        commands.put("help", this::printHelp);
        commands.put("exit", this::exitGame);
    }

    public void startGame() {
        System.out.println("Welcome to the Adventure Game!");

        while (playing) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();
            processInput(input);
        }
        scanner.close();
    }

    private void processInput(String input) {
        String[] splitInput = input.split(" ", 2);  // Split input into command and argument
        String command = splitInput[0];

        if (command.equals("go")) {
            if (splitInput.length > 1) {
                System.out.println(adventure.movePlayer(splitInput[1]));
            } else {
                System.out.println("Go where?");
            }
        } else if (command.equals("north") || command.equals("n")) {
            System.out.println(adventure.movePlayer("north"));
        } else if (command.equals("south") || command.equals("s")) {
            System.out.println(adventure.movePlayer("south"));
        } else if (command.equals("east") || command.equals("e")) {
            System.out.println(adventure.movePlayer("east"));
        } else if (command.equals("west") || command.equals("w")) {
            System.out.println(adventure.movePlayer("west"));
        } else if (command.equals("take")) {
            if (splitInput.length > 1) {
                System.out.println(adventure.takeItem(splitInput[1]));
            } else {
                System.out.println("Take what?");
            }
        } else if (command.equals("drop")) {
            if (splitInput.length > 1) {
                System.out.println(adventure.dropItem(splitInput[1]));
            } else {
                System.out.println("Drop what?");
            }
        } else if (command.equals("equip")) {
            if (splitInput.length > 1) {
                System.out.println(adventure.equipWeapon(splitInput[1]));
            } else {
                System.out.println("Equip what?");
            }
        } else if (command.equals("attack")) {
            if (splitInput.length > 1) {
                System.out.println(adventure.attackEnemy(splitInput[1]));
            } else {
                System.out.println("Attack who?");
            }
        } else if (command.equals("eat")) {  // Add eat command
            if (splitInput.length > 1) {
                System.out.println(adventure.eatFood(splitInput[1]));
            } else {
                System.out.println("Eat what?");
            }
        } else {
            Runnable action = commands.getOrDefault(command, this::invalidCommand);
            action.run();
        }
    }

    private void invalidCommand() {
        System.out.println("Invalid command. Type 'help' for a list of commands.");
    }

    private void printHelp() {
        System.out.println("Available commands:");
        System.out.println("go 'north/east/south/west' or simply 'north/n', 'east/e', 'south/s', 'west/w' - Move in a specific direction");
        System.out.println("look - Look around the current room");
        System.out.println("inventory - Show your current inventory");
        System.out.println("take 'item' - Take an item");
        System.out.println("drop 'item' - Drop an item");
        System.out.println("equip 'weapon' - Equip a weapon");
        System.out.println("attack 'enemy' - Attack an enemy");
        System.out.println("eat 'food' - Eat food to regain, or maybe lose, health");
        System.out.println("exit - Exit the game");
    }

    private void exitGame() {
        System.out.println("Thank you for playing!");
        playing = false;
    }
}