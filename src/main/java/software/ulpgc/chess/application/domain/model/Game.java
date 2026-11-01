package software.ulpgc.chess.application.domain.model;

import java.util.ArrayList;
import java.util.List;

public final class Game {
    private final String id;
    private final Board board;
    private final List<Move> moves;
    private final GameStatus status;

    private Game(String id, Board board, List<Move> moves, GameStatus status) {
        this.id = id;
        this.board = board;
        this.moves = List.copyOf(moves);
        this.status = status;
    }

    public static Game start(String id) {
        return new Game(id, Board.initial(), List.of(), GameStatus.Playing);
    }

    public Game play(Move move) {
        checkIsPlaying();
        checkTurn(move);
        return new Game(id, board.move(move.from(), move.to()), movesWith(move), status);
    }

    public Game finish() {
        checkIsPlaying();
        return new Game(id, board, moves, GameStatus.Finished);
    }

    public Color turn() {
        return moves.size() % 2 == 0 ? Color.White : Color.Black;
    }

    private void checkIsPlaying() {
        if (status != GameStatus.Playing) {
            throw new IllegalStateException("Game " + id + " is not being played");
        }
    }

    private void checkTurn(Move move) {
        Piece piece = board.pieceAt(move.from());
        if (piece != null && piece.color() != turn()) {
            throw new IllegalArgumentException("It is " + turn() + "'s turn");
        }
    }

    private List<Move> movesWith(Move move) {
        List<Move> result = new ArrayList<>(moves);
        result.add(move);
        return result;
    }

    public String id() {
        return id;
    }

    public Board board() {
        return board;
    }

    public List<Move> moves() {
        return moves;
    }

    public GameStatus status() {
        return status;
    }
}
