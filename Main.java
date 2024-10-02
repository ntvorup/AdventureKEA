public class Main {
    public static void main(String[] args) {
        Adventure adventure = new Adventure(new Map());
        UI ui = new UI(adventure);
        ui.start();
    }
}