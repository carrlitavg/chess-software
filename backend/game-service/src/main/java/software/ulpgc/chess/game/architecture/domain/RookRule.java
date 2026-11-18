package software.ulpgc.chess.game.architecture.domain;

import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Piece;
import software.ulpgc.chess.game.architecture.model.Position;

public class RookRule implements Rule {
    @Override
    public boolean check(Position position, Move move) {
        if (isRook(position.board().pieceAt(move.from()))) {
            return move.isStraight() && position.board().isPathClear(move.from(), move.to());
        } else {
            return true;
        }
    }

    private boolean isRook(Piece piece) {
        return piece != null && piece.isRook();
    }
}
