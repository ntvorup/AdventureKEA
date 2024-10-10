public class Map {
    private Room startRoom;

    public Map() {
        createRooms();
    }

    private void createRooms() {
        Room room1 = createRoom("the Entrance to the Temple of Forgotten Artifacts", "Ancient halls hide a sacred quest.", "You have been here before, the air is thick with mystery.");
        Room room2 = createRoom("the Chamber of Light and Darkness", "A dark, empty space.", "You have been here before, the space is still empty.");
        Room room3 = createRoom("the Hall of Locks and Keys", "A room of locked chests with a puzzle to unlock the path.", "Mysteries still surround the hall.");
        Room room4 = createRoom("the Pool of Reflections", "A dim room with a mysterious pool.", "You've pondered its secrets before.");
        Room room5 = createRoom("the Sealed Vault", "A sealed room with hidden treasures.", "The room's secrets still lie dormant.");
        Room room6 = createRoom("the Chamber of Time", "A room filled with the sound of ticking clocks.", "You feel the weight of time.");
        Room room7 = createRoom("the Forgotten Library", "A library filled with ancient books.", "Nostalgia fills this place of forgotten knowledge.");
        Room room8 = createRoom("the Hidden Passage", "A small passage.", "You're close to uncovering the secret.");
        Room room9 = createRoom("the Chamber of the Last Revelation", "A quiet room with a glowing object on a pedestal.", "You feel the weight of the moment.");

        room7.setHasSadStatue(true);  // Statue room is Room 7

        // Adding items, food, weapons, and enemies
        room1.addItem(new Item("Ancient Map", "map"));
        room4.addItem(new Item("Mysterious Amulet", "amulet"));
        room6.addItem(new Item("Silver Mirror", "mirror"));
        room2.addItem(new Item("Ancient Scroll", "scroll"));
        room8.addItem(new Item("Hourglass of Time", "hourglass"));
        room9.addItem(new Item("Tome of Forgotten Knowledge", "tome"));

        // Adding food
        room2.addItem(new Food("Shiny Apple", "apple", 15));
        room4.addItem(new Food("Magic Elixir", "elixir", 25));
        room6.addItem(new Food("Mystic Berries", "berries", -20));
        room8.addItem(new Food("Golden Honey", "honey", 50));

        // Adding weapons and enemies
        room2.addItem(new MeleeWeapon("Rusty Sword", "sword", 6));
        room4.addItem(new RangedWeapon("Shadow Bow", "bow", 70, 2));
        room6.addItem(new MeleeWeapon("Silver Dagger", "dagger", 20));
        room7.addItem(new MeleeWeapon("Lantern Club", "club", 30));
        room9.addItem(new RangedWeapon("Crystal Bow", "crystalbow", 40, 10));

        room2.addEnemy(new Enemy("Cavern Bat", 10, new MeleeWeapon("Bat Claw", "claw", 3)));
        room6.addEnemy(new Enemy("Reflection Spirit", 45, new MeleeWeapon("Spirit Blade", "spiritblade", 9)));
        room5.addEnemy(new Enemy("Vault Guardian", 60, new RangedWeapon("Guardian Crossbow", "crossbow", 12, 5)));
        room8.addEnemy(new Enemy("Passage Serpent", 40, new MeleeWeapon("Serpent Fang", "fang", 8)));

        setExits(room1, "east", room2);
        setExits(room2, "east", room3);
        setExits(room7, "east", room8);
        setExits(room8, "east", room9);
        setExits(room1, "south", room4);
        setExits(room3, "south", room6);
        setExits(room4, "south", room7);
        setExits(room5, "south", room8);
        setExits(room6, "south", room9);

        startRoom = room1;
    }

    private void setExits(Room fromRoom, String direction, Room toRoom) {
        fromRoom.setExit(direction, toRoom);
        String oppositeDirection = getOppositeDirection(direction);
        toRoom.setExit(oppositeDirection, fromRoom);
    }

    private String getOppositeDirection(String direction) {
        switch (direction) {
            case "north":
                return "south";
            case "south":
                return "north";
            case "east":
                return "west";
            case "west":
                return "east";
            default:
                return "";  // In case of invalid direction, return empty string
        }
    }

    private Room createRoom(String name, String description, String revisitedDescription) {
        return new Room(name, description, revisitedDescription);
    }

    public Room getStartRoom() {
        return startRoom;
    }
}