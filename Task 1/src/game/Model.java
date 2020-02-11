package game;

public class Model {
    private int conceivedNumber;

    public Model(int min, int max) {
        this.conceivedNumber = randNumber(min,max);
    }

    public int getConceivedNumber() {
        return conceivedNumber;
    }

    public int randNumber(int min, int max) {
        return (min + (int) (Math.random() * max));
    }
}
