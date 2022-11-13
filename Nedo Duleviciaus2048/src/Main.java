import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args)throws IOException {
        //System.out.println("Hello world!");

        Screen screen = Screen.getInstance();
        List <Integer> temp= new ArrayList<>();
        temp.add(1); temp.add(3); temp.add(5); temp.add(7);
        screen.setListFree(temp);
        screen.setFirstTile();
        Tile tile = new Tile();

        Renderer renderer = new Renderer(screen);

        Rules rules   = new Rules(screen, tile);

        while(!rules.gameOver) {

            renderer.renderGame();

            byte userInput = readUserInput();

            rules.gameLogic(userInput);

        }

    }
    private static byte readUserInput() throws IOException {
        byte bytes[] = new byte[10];
        System.in.read(bytes);
        byte userInput = bytes[0];
        return userInput;
    }
}