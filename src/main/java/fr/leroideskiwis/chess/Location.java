package fr.leroideskiwis.chess;

public class Location {

    private final int x;
    private final int y;

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
}