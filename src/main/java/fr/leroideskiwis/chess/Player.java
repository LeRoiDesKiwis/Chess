package fr.leroideskiwis.chess;

import java.util.Optional;

public class Player {

    public boolean play(Board board, String fromStr, String toStr){
        Optional<Location> fromOpt = Location.parseString(fromStr);
        Optional<Location> toOpt = Location.parseString(toStr);

        if(fromOpt.isEmpty() || toOpt.isEmpty()) return false;
        Location from = fromOpt.get();
        Location to = toOpt.get();
        if(!board.possess(this, from) ||
            !board.canMove(from, to)) return false;
        board.move(from, to);
        return true;
    }

}
