package software.ulpgc.chess;

public record Square(File file, Rank rank) {
    public static Square at(String square) {
        if (square == null || square.length() != 2)
            throw new IllegalArgumentException("Invalid square: " + square);
        return new Square(fileOf(square.charAt(0)), rankOf(square.charAt(1)));
    }

    private static File fileOf(char symbol) {
        for (File file : File.values())
            if (file.symbol() == symbol) return file;
        throw new IllegalArgumentException("Invalid file: " + symbol);
    }

    private static Rank rankOf(char symbol) {
        for (Rank rank : Rank.values())
            if (rank.value() == symbol - '0') return rank;
        throw new IllegalArgumentException("Invalid rank: " + symbol);
    }
}
