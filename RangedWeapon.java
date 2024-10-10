public class RangedWeapon extends Weapon {
    private int ammo;

    public RangedWeapon(String longName, String shortName, int damage, int ammo) {
        super(longName, shortName, damage);
        this.ammo = ammo;
    }

    @Override
    public boolean canUse() {
        return ammo > 0;
    }

    @Override
    public void use() {
        if (canUse()) {
            ammo--;
            System.out.println("You shoot with the " + getLongName() + ". Remaining ammo: " + ammo);
        } else {
            System.out.println("No ammo left for " + getLongName() + "!");
        }
    }

    public int getAmmo() {
        return ammo;
    }
}
