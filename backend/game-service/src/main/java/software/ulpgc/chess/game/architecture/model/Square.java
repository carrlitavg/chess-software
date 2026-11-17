package software.ulpgc.chess.game.architecture.model;

public record Square(File file, Rank rank) {
    public static Square at(String square) {
        if (!isValid(square)) throw new ParseException("Invalid square: " + square);
        return new Square(fileOf(square.charAt(0)), rankOf(square.charAt(1)));
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
