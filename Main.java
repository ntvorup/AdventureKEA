public class Main {
    public static void main(String[] args) {
        Adventure adventure = new Adventure();
        UI ui = new UI(adventure);
        ui.startGame();
    }
}