package software.ulpgc.chess.game.architecture.domain;

import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Piece;
import software.ulpgc.chess.game.architecture.model.Position;

public class QueenRule implements Rule {
    @Override
    public boolean check(Position position, Move move) {
        if (isQueen(position.board().pieceAt(move.from()))) {
            return isStraightOrDiagonal(move) && position.board().isPathClear(move.from(), move.to());
        } else {
            return true;
        }
    }

    private boolean isQueen(Piece piece) {
        return piece != null && piece.isQueen();
    }

    private boolean isStraightOrDiagonal(Move move) {
        return move.isStraight() || move.isDiagonal();
    }
}
