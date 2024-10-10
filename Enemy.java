public class Enemy {
    private String name;
    private int health;
    private Weapon equippedWeapon;

    public Enemy(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.equippedWeapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health <= 0) {
            health = 0;
        } else {
            System.out.println(name + " has " + health + " health remaining.");
        }
    }

    public void attack(Player player) {
        if (equippedWeapon != null) {
            int damage = equippedWeapon.getDamage();
            System.out.println(name + " attacks with " + equippedWeapon.getLongName() + " and deals " + damage + " damage.");
            player.changeHealth(-damage);
        } else {
            System.out.println(name + " attacks but has no weapon!");
        }
    }

    public Weapon dropWeapon() {
        System.out.println(name + " drops " + equippedWeapon.getLongName() + ".");
        Weapon droppedWeapon = equippedWeapon;
        equippedWeapon = null;
        return droppedWeapon;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }
}