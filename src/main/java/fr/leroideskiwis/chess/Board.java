package fr.leroideskiwis.chess;

import fr.leroideskiwis.chess.pieces.Bishop;
import fr.leroideskiwis.chess.pieces.Knight;
import fr.leroideskiwis.chess.pieces.Piece;
import fr.leroideskiwis.chess.pieces.Rook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {

    private final List<Piece> pieces = new ArrayList<>();
    private final int size;

    public Board(Player player1, Player player2, int size){
        this.size = size;
        initBoard(player1, 0, 0, true);
        initBoard(player1, 0, 0, false);

        initBoard(player2, 0, size-1, true);
        initBoard(player2, 0, size-1, false);
    }

    public void initBoard(Player player, int x, int y, boolean directionX){

        int directionX1 = directionX ? 1 : -1;

        x = directionX ? x : size-1-x;
        pieces.add(new Rook(player, x, y));
        pieces.add(new Knight(player, x+directionX1, y));
        pieces.add(new Bishop(player, x+(2*directionX1), y));
        pieces.add(directionX ?
                new Queen(player, x+3, y) : new King(player, x-3, y));

        y = y==0 ? 1 : size-2;
        for(int i = 0; i < 8; i++){
            pieces.add(new Pawn(player, i, y));
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
