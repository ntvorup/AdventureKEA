import java.util.ArrayList;
import java.util.HashMap;

public class Rooms {
    private boolean visited = false;
    private boolean letterFound = false;
    private String description;
    private String seenDescription;
    private String foundDescription;
    private String roomName;
    private Rooms south, east, west, north;
    private boolean northLocked = false;
    private boolean eastLocked = false;
    private boolean southLocked = false;
    private boolean westLocked = false;
    private ArrayList<Items> items = new ArrayList<>();
    //private HashMap<String, Rooms> connectedRooms = new HashMap<>(); fix den senere

    public Rooms(String name, String description, String seenDescription, String foundDescription) {
        this.roomName = name;
        this.description = description;
        this.seenDescription = seenDescription;
        this.foundDescription = foundDescription;
    }

    public void setExit(String direction, Rooms rooms) {
        switch (direction) {
            case "north":
                this.north = rooms;
                break;
            case "east":
                this.east = rooms;
                break;
            case "south":
                this.south = rooms;
                break;
            case "west":
                this.west = rooms;
                break;
        }
    }

    public Rooms getRoomInDirection(String direction) {
        switch (direction) {
            case "north":
                if (northLocked) {
                    System.out.println("The door to the north is locked.");
                    return null;
                }
                return north;
            case "east":
                if (eastLocked) {
                    System.out.println("The door to the east is locked.");
                    return null;
                }
                return east;
            case "south":
                if (southLocked) {
                    System.out.println("The door to the south is locked.");
                    return null;
                }
                return south;
            case "west":
                if (westLocked) {
                    System.out.println("The door to the west is locked.");
                    return null;
                }
                return west;
            default:
                return null;
        }
    }

    public String getName() {
        return roomName;
    }

    public String getDescription() {
        StringBuilder desc = new StringBuilder();

        if (visited) {
            desc.append(letterFound ? foundDescription : seenDescription);
        } else {
            visited = true;
            desc.append(description);
        }

        if (!items.isEmpty()) {
            desc.append("\nItems in this room: \n");
            if (items.size() == 1) {
                desc.append(items.get(0).getLongName());
            } else {
                for (int i = 0; i < items.size(); i++) {
                    desc.append(items.get(i).getLongName());
                    if (i < items.size() - 1) {
                        desc.append(", \n");
                    }
                }
            }
        } else {
            desc.append("\nThere are no items in this room.");
        }

        return desc.toString();
    }

    public void addItem(Items items) {
        this.items.add(items);
    }

    public void removeItem(Items items) {
        this.items.remove(items);
    }

    public Items findItem(String shortName) {
        for (Items items : this.items) {
            if (items.getShortName().equals(shortName)) {
                return items;
            }
        }
        return null;
    }

    public void findLetter() {
        letterFound = true;
    }

    public void lockNorth() {
        northLocked = true;
    }

    public void unlockNorth() {
        northLocked = false;
    }
}