package fr.leroideskiwis.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChessBoard {

    private final List<ChessPiece> pieces = new ArrayList<>();

    private Optional<ChessPiece> getPiece(Location location){
        return new ArrayList<>(pieces).stream().filter(piece -> piece.isLocateAt(location)).findFirst();
    }

    public void move(ChessMove move){

        getPiece(source).ifPresent(chessPiece -> chessPiece.move(move));

    }

    public boolean canMove(ChessMove move){
        Optional<ChessPiece> chessPiece = getPiece(source);
        return chessPiece.isPresent() && chessPiece.get().canMove(dest);
    }
}
