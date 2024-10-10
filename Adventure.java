public class Adventure {
    private Player player;
    private Map gameMap;

    public Adventure() {
        gameMap = new Map();  // Initialize the map
        player = new Player(gameMap.getStartRoom());
    }

    public String movePlayer(String direction) {
        return player.move(direction);
    }

    public String look() {
        return player.look();
    }

    public String showInventory() {
        return player.inventory();
    }

    public String takeItem(String itemName) {
        return player.takeItem(itemName);
    }

    public String dropItem(String itemName) {
        return player.dropItem(itemName);
    }

    public String equipWeapon(String weaponName) {
        return player.equipWeapon(weaponName);
    }

    public String attackEnemy(String enemyName) {
        return player.attackEnemy(enemyName);
    }

    public String eatFood(String foodName) {
        return player.eatFood(foodName);
    }

    public int getPlayerHealth() {
        return player.getHealth();
    }

    public Player getPlayer() {
        return player;
    }
}