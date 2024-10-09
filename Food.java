public class Food extends Item {
    private int healthPoints;

    public Food(String longName, String shortName, int healthPoints) {
        super(longName, shortName);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public String toString() {
        String effect = healthPoints > 0 ? "Restores " + healthPoints + " health." : "Reduces health by " + Math.abs(healthPoints) + "!";
        return super.getLongName() + " (" + effect + ")";
    }
}