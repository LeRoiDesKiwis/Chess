package fr.leroideskiwis.chess;

public class Location {

    private int x;
    private int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Location location){
            return location.x == x && location.y == x;
        }
        return false;
    }

    public void move(MovementType movementType, int tiles) {

    }
}