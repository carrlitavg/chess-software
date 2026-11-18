package software.ulpgc.chess.game.architecture.domain;

import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Piece;
import software.ulpgc.chess.game.architecture.model.Position;

public class BishopRule implements Rule {
    @Override
    public boolean check(Position position, Move move) {
        if (isBishop(position.board().pieceAt(move.from()))) {
            return move.isDiagonal() && position.board().isPathClear(move.from(), move.to());
        } else {
            return true;
        }
    }

    private boolean isBishop(Piece piece) {
        return piece != null && piece.isBishop();
    }
}
