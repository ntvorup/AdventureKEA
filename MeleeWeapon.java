public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String longName, String shortName, int damage) {
        super(longName, shortName, damage);
    }

    @Override
    public boolean canUse() {
        return true;  // Melee weapons can always be used
    }

    @Override
    public void use() {
        System.out.println("You swing the " + getLongName() + "!");
    }
}
