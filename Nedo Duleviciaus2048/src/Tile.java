import java.util.Random;

public class Tile {
    private Screen screen;
    private Random random= new Random();
    private int x;
    private int y;

    public Tile() {

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
