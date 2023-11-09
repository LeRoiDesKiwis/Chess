package fr.leroideskiwis.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {

    private final List<Piece> pieces = new ArrayList<>();

    private Optional<Piece> getPiece(Location location){
        return new ArrayList<>(pieces).stream().filter(piece -> piece.isLocateAt(location)).findFirst();
    }

    public void move(Location source, Location dest){
        getPiece(source).ifPresent(piece -> piece.moveTo(dest));
    }

    public boolean canMove(Location source, Location dest){
        Optional<Piece> chessPiece = getPiece(source);
        return chessPiece.isPresent() && chessPiece.get().canMove(dest);
    }
}
