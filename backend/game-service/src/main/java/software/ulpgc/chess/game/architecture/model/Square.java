package software.ulpgc.chess.game.architecture.model;

public record Square(File file, Rank rank) {
    public static Square at(String square) {
        if (!isValid(square)) throw new ParseException("Invalid square: " + square);
        return new Square(fileOf(square.charAt(0)), rankOf(square.charAt(1)));
    }

    public int fileIndex() {
        return file.ordinal();
    }

    public int rankIndex() {
        return rank.ordinal();
    }

    public Square towards(Square to) {
        return new Square(File.values()[fileIndex() + step(fileIndex(), to.fileIndex())],
                Rank.values()[rankIndex() + step(rankIndex(), to.rankIndex())]);
    }

    private static int step(int from, int to) {
        return Integer.compare(to, from);
    }

    private static boolean isValid(String square) {
        return square != null && square.matches("[a-h][1-8]");
    }

    private static File fileOf(char symbol) {
        return File.values()[symbol - 'a'];
    }

    private static Rank rankOf(char value) {
        return Rank.values()[value - '1'];
    }

    public static class ParseException extends RuntimeException {
        public ParseException(String message) {
            super(message);
        }
    }
}
