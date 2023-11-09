package fr.leroideskiwis.chess;

import fr.leroideskiwis.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {

    private final List<Piece> pieces = new ArrayList<>();
    private final int size;

    public Board(Player player1, Player player2, int size){
        this.size = size;
        for(int y : new int[]{0, size-1}) {

            Player player = y==0 ? player1 : player2;
            for(int xDir : new int[]{-1, 1}) {
                int x = xDir == 1 ? 0 : size - 1;

                pieces.add(new Rook(player, x, y));
                pieces.add(new Knight(player, x + xDir, y));
                pieces.add(new Bishop(player, x + (2 * xDir), y));

                if(xDir == 1) pieces.add(new Queen(player, x + 3, y));
                else pieces.add(new King(player, x - 3, y));
            }

            y = y == 0 ? 1 : size - 2;
            for (int i = 0; i < 8; i++) {
                pieces.add(new Pawn(player, i, y));
            }

        }
    }

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

    public void display(){
        for(int x = 0; x < size; x++){

            for(int y = 0; y < size; y++){
                Optional<Piece> piece = getPiece(new Location(y, x));
                piece.ifPresentOrElse(
                        p -> System.out.printf("%s ", p),
                        () -> System.out.print(". "));
                            }

            System.out.println();
        }
    }
}
