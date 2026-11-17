package software.ulpgc.chess.game.architecture.model;

public enum Color {
    White, Black;

    public Color opposite() {
        if (this == White) {
            return Black;
        } else {
            return White;
        }
    }
}
