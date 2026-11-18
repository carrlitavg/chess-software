package software.ulpgc.chess.game.architecture.domain;

import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Piece;
import software.ulpgc.chess.game.architecture.model.Position;

public class KnightRule implements Rule {
    @Override
    public boolean check(Position position, Move move) {
        if (isKnight(position.board().pieceAt(move.from()))) {
            return isLShaped(move);
        } else {
            return true;
        }
    }

    private boolean isKnight(Piece piece) {
        return piece != null && piece.isKnight();
    }

    private boolean isLShaped(Move move) {
        return move.fileDistance() * move.rankDistance() == 2;
    }
}
