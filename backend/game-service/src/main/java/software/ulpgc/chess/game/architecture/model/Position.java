package software.ulpgc.chess.game.architecture.model;

import static software.ulpgc.chess.game.architecture.model.Color.White;

public record Position(Board board, Color turn) {
    public static Position initial() {
        return new Position(Board.initial(), White);
    }

    public Position next(Move move) {
        return new Position(board.move(move.from(), move.to()), turn.opposite());
    }
}
