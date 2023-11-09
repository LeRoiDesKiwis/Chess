package fr.leroideskiwis.chess;

public class Location {

    private int x;
    private int y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move(Location location){
        this.x = location.x;
        this.y = location.y;
    }

    public int[] diff(Location location){
        return new int[]{this.x-location.x, this.y-location.y};
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Location location){
            return location.x == x && location.y == x;
        }
        return false;
    }
}