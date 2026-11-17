package software.ulpgc.chess.game.architecture.model;

public record Move(Square from, Square to) {
    public int fileDistance() {
        return Math.abs(to.fileIndex() - from.fileIndex());
    }

    public int rankDistance() {
        return Math.abs(rankShift());
    }

    public int rankShift() {
        return to.rankIndex() - from.rankIndex();
    }

    public boolean isStraight() {
        return fileDistance() == 0 || rankDistance() == 0;
    }

    public boolean isDiagonal() {
        return fileDistance() == rankDistance();
    }
}
