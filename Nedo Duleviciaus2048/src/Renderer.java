import java.util.Collections;
import java.util.Random;

public class Renderer {
    private Screen screen;
    private Random random= new Random();
    //┍ ┖ ┙ ┓

    public Renderer(Screen screen) {
        this.screen = screen;
    }

    public void renderGame() {
        for (int y=0; y<screen.getLength(); y++) {
            for (int x=0; x<screen.getLength(); x++) {
                if (screen.getListFree().contains(y) && screen.getListFree().contains(x))
                    System.out.print(screen.getValue(x, y));
                else
                if (screen.isLeftUpCorner(x, y))
                    System.out.print("┍");
                else
                if (screen.isLeftDownCorner(x, y))
                    System.out.print("┖");
                else
                if (screen.isRightDownCorner(x, y))
                    System.out.print("┙");
                else
                if (screen.isRightUpCorner(x, y))
                    System.out.print("┓");
                else
                if (screen.isBorder(x, y))
                    System.out.print("-");
                else
                if (screen.isSideBorder(x, y))
                    System.out.print("|");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
