package fr.leroideskiwis.chess;

import java.util.Optional;

public class Location {

    private int x;
    private int y;

    public static Optional<Location> parseString(String s){
        if(s.length() < 2) return Optional.empty();
        int x;
        try {
            x = Integer.parseInt(String.valueOf(s.charAt(1)).toLowerCase())-1;
        }catch(NumberFormatException e){
            return Optional.empty();
        }
        String values = "abcdefgh";
        String yChar = String.valueOf(s.charAt(0));
        if(!values.contains(yChar)) return Optional.empty();
        Location location = new Location(x, values.indexOf(yChar));
        return Optional.of(location);

    }

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
            return location.x == x && location.y == y;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("x = %d ; y = %d", x, y);
    }
}