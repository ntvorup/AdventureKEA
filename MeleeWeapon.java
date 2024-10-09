public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String longName, String shortName) {
        super(longName, shortName);
    }

    @Override
    public boolean canUse() {
        return true; // Melee weapons can always be used
    }

    @Override
    public void use() {
        System.out.println("You swing the " + getLongName() + "!");
    }
}