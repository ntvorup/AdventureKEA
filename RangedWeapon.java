public class RangedWeapon extends Weapon {
    private int ammo;

    public RangedWeapon(String longName, String shortName, int ammo) {
        super(longName, shortName);
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
            System.out.println("You have run out of ammo for the " + getLongName() + "!");
        }
    }

    public int remainingUses() {
        return ammo;
    }
}