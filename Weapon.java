public abstract class Weapon extends Item {
    protected int damage;

    public Weapon(String longName, String shortName, int damage) {
        super(longName, shortName);
        this.damage = damage;
    }

    public abstract boolean canUse();
    public abstract void use();

    public int getDamage() {
        return damage;
    }
}
