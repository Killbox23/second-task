import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Screen {
    private Random random= new Random();
    private static final Screen instance = new Screen();

    private Screen(){}

    public static Screen getInstance() {
        return instance;
    }
    private int[][] screen = {
            {1, 5, 5, 5, 5, 5, 5, 5, 10},
            {3, 0, 3, 0, 3, 0, 3, 0, 3},
            {3, 5, 5, 5, 5, 5, 5, 5, 3},
            {3, 0, 3, 0, 3, 0, 3, 0, 3},
            {3, 5, 5, 5, 5, 5, 5, 5, 3},
            {3, 0, 3, 0, 3, 0, 3, 0, 3},
            {3, 5, 5, 5, 5, 5, 5, 5, 3},
            {3, 0, 3, 0, 3, 0, 3, 0, 3},
            {20, 5, 5, 5, 5, 5, 5, 5, 30}
    };
    private List<Integer> listFree= new ArrayList<>();
    private boolean LeftStuck=false;
    private boolean RightStuck=false;
    private boolean UpStuck=false;
    private boolean DownStuck=false;
    public int getLength() {
        return screen.length;
    }


    public boolean isBorder(int x, int y) {
                return screen[y][x] == 5;
            }
            //┍ ┖ ┙ ┓
    public boolean isSideBorder(int x, int y) {
        return screen[y][x] == 3;
    }
    public boolean isLeftUpCorner(int x, int y) {
                return screen[y][x] == 1;
            }
    public boolean isLeftDownCorner(int x, int y) {
        return screen[y][x] == 20;
    }
    public boolean isRightUpCorner(int x, int y) {
        return screen[y][x] == 10;
    }
    public boolean isRightDownCorner(int x, int y) {
        return screen[y][x] == 30;
    }

    public int getValue (int x, int y){
        return screen[y][x];
    }
    public void multiplyValue (int x, int y){
        screen[y][x]=screen[y][x]*2;
    }
    public void spawnValue (int x, int y){
        screen[y][x]=2;
    }
    public void setValueZero (int x, int y){
        screen[y][x]=0;
    }
    public void replaceValue (int x, int y, int x2, int y2){
        screen[y][x]=screen[y2][x2];
    }
    public List<Integer> getListFree() {
        return listFree;
    }

    public void setListFree(List<Integer> listFree) {
        this.listFree = listFree;
    }
    public int getCoordinate() {
        return getListFree().get(random.nextInt(getListFree().size()));
    }
    public void setFirstTile() {
        spawnValue(getCoordinate(),getCoordinate());
    }

    public boolean isUpStuck() {
        return UpStuck;
    }

    public void setUpStuck(boolean upStuck) {
        UpStuck = upStuck;
    }

    public boolean isDownStuck() {
        return DownStuck;
    }

    public void setDownStuck(boolean downStuck) {
        DownStuck = downStuck;
    }

    public boolean isRightStuck() {
        return RightStuck;
    }

    public void setRightStuck(boolean rightStuck) {
        RightStuck = rightStuck;
    }

    public boolean isLeftStuck() {
        return LeftStuck;
    }

    public void setLeftStuck(boolean leftStuck) {
        LeftStuck = leftStuck;
    }
}
