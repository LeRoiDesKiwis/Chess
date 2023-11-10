package fr.leroideskiwis.chess;

public class Player {

    private final int id;

    public Player(int id){
        this.id = id;
    }

    public boolean play(Board board, Location from, Location to){
        if(!board.possess(this, from) ||
            !board.canMove(from, to)) return false;
        board.move(from, to);
        return true;
    }

    //TODO
    public boolean isCheckmate(){
        return false;
    }

    @Override
    public String toString() {
        return "Player "+id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Player && ((Player)obj).id == this.id;
    }
}
