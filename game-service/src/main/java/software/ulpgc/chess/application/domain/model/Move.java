package software.ulpgc.chess.application.domain.model;

public record Move(Square from, Square to) {
    public static Move of(String from, String to) {
        return new Move(Square.at(from), Square.at(to));
    }
}
