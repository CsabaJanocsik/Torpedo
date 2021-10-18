package hu.nye.progtech.torpedo.model;

public class Controller { private char ship = 'S';
    private char hit = '+';
    private char miss = 'X';
    private char clearShip = '#';
    private boolean gameStart = false;

    public Controller(boolean gameStart) {
        this.gameStart = gameStart;
    }

    public char getShip() {
        return ship;
    }

    public char getHit() {
        return hit;
    }

    public char getMiss() {
        return miss;
    }

    public char getClearShip() {
        return clearShip;
    }

    public boolean isGameStart() {
        return gameStart;
    }

    public void main(String[] args) {
        while (this.gameStart==true){

        }
    }

}
