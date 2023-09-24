package fr.leroideskiwis.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChessBoard {

    private final List<ChessPiece> pieces = new ArrayList<>();

    private Optional<ChessPiece> getPiece(Location location){
        return new ArrayList<>(pieces).stream().filter(piece -> piece.isLocateAt(location)).findFirst();
    }

    public void move(Location source, Location dest){
        getPiece(source).ifPresent(chessPiece -> {
            pieces.remove(chessPiece);
            pieces.add(chessPiece.moveTo(dest));
        });
    }

    public boolean canMove(Location source, Location dest){
        Optional<ChessPiece> chessPiece = getPiece(source);
        return chessPiece.isPresent() && chessPiece.get().canMove(dest);
    }
}
