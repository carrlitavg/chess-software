package software.ulpgc.chess.game.architecture.domain;

import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Piece;
import software.ulpgc.chess.game.architecture.model.Position;

public class TurnRule implements Rule {
    @Override
    public boolean check(Position position, Move move) {
        Piece piece = position.board().pieceAt(move.from());
        return piece != null && piece.color() == position.turn();
    }
}
