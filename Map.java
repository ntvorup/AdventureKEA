public class Map {
    private Rooms startRooms;

    public Map() {
        createRooms();
    }

    private void createRooms() {
        Rooms rooms1 = new Rooms(
                "the Entrance to the Forgotten Forest",
                "You stand at the entrance to a dark and mysterious forest, with unknown paths ahead.",
                "You've been here before, but the shadows seem to shift.",
                "You see the letter 'A' glowing at your feet."
        );
        Rooms rooms2 = new Rooms(
                "the Echoing Cavern",
                "A large, echoing cavern where your footsteps resonate. Traces of lost adventurers can be seen on the walls.",
                "You can hear whispers echoing around you.",
                "The letter 'L' shines softly in the darkness."
        );

        Rooms rooms3 = new Rooms(
                "the Entrance to the Forgotten Temple",
                "Within these ancient halls, shrouded in mystery and whispers of time, lies a sacred quest.\n"
                        + "Your mission, should you dare to embrace it, is to uncover the long-forgotten word, that holds the key to the secrets of this enchanted temple.\n"
                        + "Seek wisely, for the path ahead is fraught with enigmas and revelations that will guide you to the treasures of your heart's desire.\n"
                        + "But beware, for darkness lurks in the shadows, and malevolent forces guard the paths you must 'T'read...",
                "You have been here before, and the air is thick with mystery.",
                "You see the letter 'O' shining brightly on the ground, illuminating your path."
        );
        Rooms rooms4 = new Rooms(
                "the Chamber of Light and Darkness",
                "Everything here is consumed by total darkness. The air feels cold and empty, with no walls or shapes in sight.\n"
                        + "A whisper echoes in the abyss:\n"
                        + "'In the darkness, there is nothing, but when the light is turned on, the truth is revealed.'\n"
                        + "\nWhat will you do?",
                "You are in a chamber filled with shadows and uncertainty.",
                "You notice a letter 'H' glowing faintly, waiting to be discovered."
        );

        Rooms rooms5 = new Rooms(
                "the Hall of Locks and Keys",
                "The room is cluttered with locked chests, each one seemingly guarding a secret. A faint inscription on the wall reads:\n"
                        + "The path is revealed by the order in which you unlock.\n"
                        + "\nWhat will you do?",
                "You have revisited this hall filled with mysteries.",
                "A letter 'O' lies on a dusty shelf, catching your eye."
        );

        Rooms rooms6 = new Rooms(
                "the Pool of Reflections",
                "The room is dimly lit, dominated by a mysterious pool of water at its center. Inscribed on the wall are the words:\n"
                        + "'When you gaze into the depths, your answer will be reflected back.'\n"
                        + "\nWhat will you do?",
                "You've stood by this pool before, pondering its secrets.",
                "A shimmering letter 'M' floats just beneath the surface of the water."
        );

        Rooms rooms7 = new Rooms(
                "the Sealed Vault",
                "",
                "",
                ""
        );

        Rooms rooms8 = new Rooms(
                "the Chamber of Time",
                "As you enter the room, you are greeted by the sight of large, ornate clocks ticking loudly, each set to a different time.\n"
                        + "The air is thick with tension, as a voice echoes through the chamber, announcing that you have 2 minutes to solve a riddle.\n"
                        + "Should you fail, the consequences will be dire.\n"
                        + "\nWhat will you do?",
                "You can feel the weight of time pressing down on you.",
                "O"
        );

        Rooms rooms9 = new Rooms(
                "the Forgotten Library",
                "This room is lined with towering shelves filled with ancient, dust-covered books. Somewhere among them lies an old tome containing a cryptic message.\n"
                        + "\nWhat will you do?",
                "You feel a sense of nostalgia in this library of forgotten knowledge.",
                "A letter 'R' is tucked between the pages of an ancient book."
        );

        Rooms rooms10 = new Rooms(
                "the Hidden Passage",
                "This stone chamber features a locked passage to the north, barring the way forward.\n"
                        + "Strange symbols are etched around the doorframe, as if hinting at some secret mechanism.\n"
                        + "You sense that the key to unlocking the door may lie in the fragments you've been gathering.\n"
                        + "\nThe answer seems to be just within reach...",
                "You've returned to this hidden chamber, pondering its secrets.",
                ""
        );

        Rooms rooms11 = new Rooms(
                "the Chamber of the Last Revelation",
                "The room is quiet, a dimly lit room, its air thick with anticipation. At its center, an ancient pedestal holds a small, glowing object.\n"
                        + "\nWhat will you do?",
                "You've entered this chamber before, feeling the weight of the moment.",
                "A letter 'A' rests on the pedestal, radiating light."
        );

        Items torch = new Items("the torch of eternal flame", "torch");
        Items book = new Items("a dusty old book", "book");
        Items scroll = new Items("a fragile parchment with faded symbols", "scroll");
        Items orb = new Items("a glowing orb", "orb");
        Items chalice = new Items("an intricately designed silver chalice", "chalice");
        Items leftAmulet = new Items("the left side of a gemstone amulet, split down the middle", "amulet");
        Items rightAmulet = new Items("the right side of a gemstone amulet, split down the middle", "amulet");

        rooms3.addItem(torch);
        rooms7.addItem(book);
        rooms4.addItem(chalice);
        rooms8.addItem(scroll);
        rooms9.addItem(orb);
        rooms6.addItem(leftAmulet);
        rooms2.addItem(rightAmulet);

        connectRooms(rooms1, "north", rooms2);
        connectRooms(rooms2, "east", rooms3);
        connectRooms(rooms3, "east", rooms4);
        connectRooms(rooms3, "south", rooms6);
        connectRooms(rooms4, "east", rooms5);
        connectRooms(rooms5, "south", rooms8);
        connectRooms(rooms6, "south", rooms9);
        connectRooms(rooms7, "south", rooms10);
        connectRooms(rooms8, "south", rooms11);
        connectRooms(rooms9, "east", rooms10);
        connectRooms(rooms10, "east", rooms11);

        rooms10.lockNorth();

        startRooms = rooms1;
    }

    private void connectRooms(Rooms rooms1, String direction, Rooms rooms2) {
        rooms1.setExit(direction, rooms2);
        switch (direction) {
            case "north":
                rooms2.setExit("south", rooms1);
                break;
            case "south":
                rooms2.setExit("north", rooms1);
                break;
            case "east":
                rooms2.setExit("west", rooms1);
                break;
            case "west":
                rooms2.setExit("east", rooms1);
                break;
        }
    }

    public Rooms getStartRoom() {
        return startRooms;
    }
}