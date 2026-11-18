package software.ulpgc.chess.game.architecture.domain;

import software.ulpgc.chess.game.architecture.model.*;

import static software.ulpgc.chess.game.architecture.model.Color.White;

public class PawnRule implements Rule {
    @Override
    public boolean check(Position position, Move move) {
        Piece piece = position.board().pieceAt(move.from());
        if (piece != null && piece.isPawn()) {
            return isAdvance(position.board(), move, piece.color()) || isCapture(position.board(), move, piece.color());
        } else {
            return true;
        }
    }

    private boolean isAdvance(Board board, Move move, Color color) {
        return move.fileDistance() == 0 && isFree(board, move) && isOneOrTwoSteps(move, color);
    }

    private boolean isFree(Board board, Move move) {
        return board.pieceAt(move.to()) == null && board.isPathClear(move.from(), move.to());
    }

    private boolean isOneOrTwoSteps(Move move, Color color) {
        return steps(move, color) == 1 || (steps(move, color) == 2 && isAtStart(move.from(), color));
    }

    private boolean isCapture(Board board, Move move, Color color) {
        return move.fileDistance() == 1 && steps(move, color) == 1 && board.pieceAt(move.to()) != null;
    }

    private int steps(Move move, Color color) {
        if (color == White) {
            return move.rankShift();
        } else {
            return -move.rankShift();
        }
    }

    private boolean isAtStart(Square square, Color color) {
        if (color == White) {
            return square.rankIndex() == 1;
        } else {
            return square.rankIndex() == 6;
        }
    }
}
