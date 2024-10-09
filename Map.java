public class Map {
    private Room startRoom;

    public Map() {
        createRooms();
    }

    private void createRooms() {
        Room room1 = new Room(
                "the Entrance to the Forgotten Forest",
                "You stand at the entrance to a dark and mysterious forest, with unknown paths ahead. There's a distinct smell coming from the north",
                "You've been here before, but the shadows seem to shift."
        );
        Room room2 = new Room(
                "the Echoing Cavern",
                "A large, echoing cavern where your footsteps resonate. Traces of lost adventurers can be seen on the walls.",
                "You can hear whispers echoing around you."
        );

        Room room3 = new Room(
                "the Entrance to the Forgotten Temple",
                "Within these ancient halls, shrouded in mystery and whispers of time, lies a sacred quest.\n"
                        + "Your mission, should you dare to embrace it, is to uncover the long-forgotten word, that holds the key to the secrets of this enchanted temple.\n"
                        + "Seek wisely, for the path ahead is fraught with enigmas and revelations that will guide you to the treasures of your heart's desire.\n"
                        + "But beware, for darkness lurks in the shadows, and malevolent forces guard the paths you must tread...",
                "You have been here before, and the air is thick with mystery."
        );
        Room room4 = new Room(
                "the Chamber of Light and Darkness",
                "Everything here is consumed by total darkness. The air feels cold and empty, with no walls or shapes in sight.\n"
                        + "A whisper echoes in the abyss:\n"
                        + "'In the darkness, there is nothing, but when the light is turned on, the truth is revealed.'\n"
                        + "\nWhat will you do?",
                "You are in a chamber filled with shadows and uncertainty."
        );

        Room room5 = new Room(
                "the Hall of Locks and Keys",
                "The room is cluttered with locked chests, each one seemingly guarding a secret. A faint inscription on the wall reads:\n"
                        + "The path is revealed by the order in which you unlock.\n"
                        + "\nWhat will you do?",
                "You have revisited this hall filled with mysteries."
        );

        Room room6 = new Room(
                "the Pool of Reflections",
                "The room is dimly lit, dominated by a mysterious pool of water at its center. Inscribed on the wall are the words:\n"
                        + "'When you gaze into the depths, your answer will be reflected back.'\n"
                        + "\nWhat will you do?",
                "You've stood by this pool before, pondering its secrets."
        );

        Room room7 = new Room(
                "the Sealed Vault",
                "",
                ""
        );

        Room room8 = new Room(
                "the Chamber of Time",
                "As you enter the room, you are greeted by the sight of large, ornate clocks ticking loudly, each set to a different time.\n"
                        + "The air is thick with tension, as a voice echoes through the chamber, announcing that you have 2 minutes to solve a riddle.\n"
                        + "Should you fail, the consequences will be dire.\n"
                        + "\nWhat will you do?",
                "You can feel the weight of time pressing down on you."
        );

        Room room9 = new Room(
                "the Forgotten Library",
                "This room is lined with towering shelves filled with ancient, dust-covered books. Somewhere among them lies an old tome containing a cryptic message.\n"
                        + "\nWhat will you do?",
                "You feel a sense of nostalgia in this library of forgotten knowledge."
        );

        Room room10 = new Room(
                "the Hidden Passage",
                "This stone chamber features a locked passage to the north, barring the way forward.\n"
                        + "Strange symbols are etched around the doorframe, as if hinting at some secret mechanism.\n"
                        + "You sense that the key to unlocking the door may lie in the fragments you've been gathering.\n"
                        + "\nThe answer seems to be just within reach...",
                "You've returned to this hidden chamber, pondering its secrets."
        );

        Room room11 = new Room(
                "the Chamber of the Last Revelation",
                "The room is quiet, a dimly lit room, its air thick with anticipation. At its center, an ancient pedestal holds a small, glowing object.\n"
                        + "\nWhat will you do?",
                "You've entered this chamber before, feeling the weight of the moment."
        );

        Item torch = new Item("the torch of eternal flame", "torch");
        Item book = new Item("a dusty old book", "book");
        Item scroll = new Item("a fragile parchment with faded symbols", "scroll");
        Item orb = new Item("a glowing orb", "orb");
        Item chalice = new Item("an intricately designed silver chalice", "chalice");
        Item leftAmulet = new Item("the left side of a gemstone amulet, split down the middle", "amulet");
        Item rightAmulet = new Item("the right side of a gemstone amulet, split down the middle", "amulet");
        Food apple = new Food("a juicy red apple", "apple", 10);
        Food poisonedBerry = new Food("a handful of suspicious berries", "berries", -20);
        Food jerky = new Food("a dry piece of beef jerky", "jerky meat", 25);
        Weapon sword = new MeleeWeapon("shiny sword","sword");
        Weapon bow = new RangedWeapon("old bow", "bow", 15);


        room2.addItem(sword);
        room4.addItem(bow);
        room3.addItem(apple);
        room1.addItem(poisonedBerry);
        room5.addItem(jerky);
        room3.addItem(torch);
        room7.addItem(book);
        room4.addItem(chalice);
        room8.addItem(scroll);
        room9.addItem(orb);
        room6.addItem(leftAmulet);
        room2.addItem(rightAmulet);

        connectRooms(room1, "north", room2);
        connectRooms(room2, "east", room3);
        connectRooms(room3, "east", room4);
        connectRooms(room3, "south", room6);
        connectRooms(room4, "east", room5);
        connectRooms(room5, "south", room8);
        connectRooms(room6, "south", room9);
        connectRooms(room7, "south", room10);
        connectRooms(room8, "south", room11);
        connectRooms(room9, "east", room10);
        connectRooms(room10, "east", room11);

        room10.lockNorth();

        startRoom = room1;
    }

    private void connectRooms(Room room1, String direction, Room room2) {
        room1.setExit(direction, room2);
        switch (direction) {
            case "north":
                room2.setExit("south", room1);
                break;
            case "south":
                room2.setExit("north", room1);
                break;
            case "east":
                room2.setExit("west", room1);
                break;
            case "west":
                room2.setExit("east", room1);
                break;
        }
    }

    public Room getStartRoom() {
        return startRoom;
    }
}