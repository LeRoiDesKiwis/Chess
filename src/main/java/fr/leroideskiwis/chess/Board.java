package fr.leroideskiwis.chess;

import fr.leroideskiwis.chess.pieces.Bishop;
import fr.leroideskiwis.chess.pieces.Knight;
import fr.leroideskiwis.chess.pieces.Piece;
import fr.leroideskiwis.chess.pieces.Rook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

public class Board {

    private final List<Piece> pieces = new ArrayList<>();
    private final int size;

    public Board(Player player1, Player player2, int size){
        this.size = size;
        init1(player1, 0, 0, true);
        init1(player1, 0, 0, false);

        init1(player1, 0, size-1, true);
        init1(player1, 0, size-1, false);
    }

    public void init1(Player player, int x, int y, boolean directionX){

        BiFunction<Integer, Integer, Integer> add = directionX ?
                (Integer::sum) :
                ((n, n1) -> n-n1);

        x = directionX ? x : size-1-x;
        pieces.add(new Rook(player, x, y));
        pieces.add(new Knight(player, add.apply(x, 1), y));
        pieces.add(new Bishop(player, add.apply(x, 2), y));
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
