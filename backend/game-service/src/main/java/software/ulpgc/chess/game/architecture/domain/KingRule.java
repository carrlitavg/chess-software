package software.ulpgc.chess.game.architecture.domain;

import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Piece;
import software.ulpgc.chess.game.architecture.model.Position;

public class KingRule implements Rule {
    @Override
    public boolean check(Position position, Move move) {
        if (isKing(position.board().pieceAt(move.from()))) {
            return isOneStep(move);
        } else {
            return true;
        }
    }

    private boolean isKing(Piece piece) {
        return piece != null && piece.isKing();
    }

    private boolean isOneStep(Move move) {
        return move.fileDistance() <= 1 && move.rankDistance() <= 1;
    }
}
