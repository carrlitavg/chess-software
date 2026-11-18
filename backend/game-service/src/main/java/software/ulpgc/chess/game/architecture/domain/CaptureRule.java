package software.ulpgc.chess.game.architecture.domain;

import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Piece;
import software.ulpgc.chess.game.architecture.model.Position;

public class CaptureRule implements Rule {
    @Override
    public boolean check(Position position, Move move) {
        Piece target = position.board().pieceAt(move.to());
        return target == null || target.color() != position.turn();
    }
}
