import java.util.Random;

public class Rules {
    private Screen screen;
    private Tile tile;
    private Random random = new Random();
    public boolean gameOver = false;

    public void gameLogic(byte userInput) {
        switch (userInput) {//input
            case 'q':
                gameOver = true;
                System.out.print("game over");
                break;
            case 'a':
                screen.setLeftStuck(true);
                for (int y = screen.getLength() - 2; y > 0; y -= 2) {// 16 8 4 4
                    for (int x = 1; x < screen.getLength() - 2; x += 2) {
                        if (screen.getValue(x, y) == screen.getValue(x + 2, y) && screen.getValue(x + 2, y) != 0) {
                            screen.multiplyValue(x, y);
                            screen.setValueZero(x + 2, y);
                            screen.setLeftStuck(false);
                        } else if (screen.getValue(x, y) == 0 && screen.getValue(x + 2, y) != 0) {
                            screen.replaceValue(x, y, x + 2, y);
                            screen.setValueZero(x, y);
                            screen.setLeftStuck(false);
                        }
                    }
                }
                if (!screen.isLeftStuck()) {
                    generateTile();
                }
                break;
            case 'd':
                screen.setRightStuck(true);
                for (int y = screen.getLength() - 2; y > 0; y -= 2) {// 16 8 4 4
                    for (int x = screen.getLength() - 2; x > 1; x -= 2) {
                        if (screen.getValue(x, y) == screen.getValue(x - 2, y) && screen.getValue(x - 2, y) != 0) {
                            screen.multiplyValue(x, y);
                            screen.setValueZero(x - 2, y);
                            screen.setRightStuck(false);
                        } else if (screen.getValue(x, y) == 0 && screen.getValue(x - 2, y) != 0) {
                            screen.replaceValue(x, y, x - 2, y);
                            screen.setValueZero(x - 2, y);
                            screen.setRightStuck(false);
                        }
                    }
                }
                if (!screen.isRightStuck()) {
                    generateTile();
                }
                break;
            case 'w':
                screen.setUpStuck(true);
                for (int x = 1; x <= screen.getLength() - 2; x += 2) {// 16 8 4 4
                    for (int y = 1; y < screen.getLength() - 2; y += 2) {
                        if (screen.getValue(x, y) == screen.getValue(x, y + 2) && screen.getValue(x, y) != 0) {
                            screen.multiplyValue(x, y);
                            screen.setValueZero(x, y + 2);
                            screen.setUpStuck(false);
                        } else if (screen.getValue(x, y) == 0 && screen.getValue(x, y + 2) != 0) {
                            screen.replaceValue(x, y, x, y + 2);
                            screen.setValueZero(x, y + 2);
                            screen.setUpStuck(false);
                        }
                    }
                }
                if (!screen.isUpStuck()) {
                    generateTile();
                }
                break;
            case 's':
                screen.setDownStuck(true);
                for (int x = 1; x <= screen.getLength() - 2; x += 2) {// 16 8 4 4
                    for (int y = screen.getLength() - 2; y > 1; y -= 2) {
                        if (screen.getValue(x, y) == screen.getValue(x, y - 2)) {
                            screen.multiplyValue(x, y);
                            screen.setValueZero(x, y - 2);
                            screen.setDownStuck(false);
                        } else if (screen.getValue(x, y) == 0 && screen.getValue(x, y - 2) != 0) {
                            screen.replaceValue(x, y, x, y - 2);
                            screen.setValueZero(x, y - 2);
                            screen.setDownStuck(false);
                        }
                    }
                    if (!screen.isDownStuck()) {
                        generateTile();
                    }
                    break;
                }
        }
        if (checkIf2048())
        {
            gameOver=true;
        }
        if (screen.isUpStuck() && screen.isDownStuck() && screen.isLeftStuck() && screen.isRightStuck())
        {
            gameOver=true;
            System.out.print("game over");
        }
    }
    public void setFreeSpace (int x, int y)
    {
        while(screen.getValue(tile.getX(),tile.getY())!=0) {
            tile.setX(screen.getCoordinate());
            tile.setY(screen.getCoordinate());
        }
    }
private boolean checkIf2048 (){
    for (int x = 1; x <= screen.getLength() - 2; x += 2) {// 16 8 4 4
        for (int y = screen.getLength() - 2; y > 1; y -= 2) {
            if (screen.getValue(x,y)==2048) {
                return true;
            }
        }
    }
    return false;
}
    private void generateTile() {
        setFreeSpace(tile.getX(), tile.getY());
        screen.spawnValue(tile.getX(), tile.getY());
    }

    public Rules(Screen screen, Tile tile) {
        this.screen = screen;
        this.tile = tile;
    }
}
