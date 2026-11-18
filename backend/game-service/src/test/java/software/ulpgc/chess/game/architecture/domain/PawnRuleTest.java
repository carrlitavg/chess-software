package software.ulpgc.chess.game.architecture.domain;

import org.junit.jupiter.api.Test;
import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Position;

import static org.junit.jupiter.api.Assertions.*;
import static software.ulpgc.chess.game.architecture.model.Square.at;

public class PawnRuleTest {
    private final Rule rule = new PawnRule();

    @Test
    void pawn_should_advance_one_or_two_squares_from_the_start() {
        assertTrue(rule.check(Position.initial(), new Move(at("e2"), at("e3"))));
        assertTrue(rule.check(Position.initial(), new Move(at("e2"), at("e4"))));
    }

    @Test
    void black_pawn_should_advance_down() {
        Position position = Position.initial().next(new Move(at("e2"), at("e4")));
        assertTrue(rule.check(position, new Move(at("e7"), at("e5"))));
    }

    @Test
    void pawn_should_not_advance_three_squares_or_backwards() {
        Position position = Position.initial().next(new Move(at("e2"), at("e4")));
        assertFalse(rule.check(Position.initial(), new Move(at("e2"), at("e5"))));
        assertFalse(rule.check(position, new Move(at("e4"), at("e3"))));
    }

    @Test
    void pawn_should_advance_two_squares_only_from_the_start() {
        Position position = Position.initial().next(new Move(at("e2"), at("e3")));
        assertFalse(rule.check(position, new Move(at("e3"), at("e5"))));
    }

    @Test
    void pawn_should_not_advance_onto_a_piece() {
        Position position = Position.initial()
                .next(new Move(at("e2"), at("e4")))
                .next(new Move(at("e7"), at("e5")));
        assertFalse(rule.check(position, new Move(at("e4"), at("e5"))));
    }

    @Test
    void pawn_should_capture_diagonally() {
        Position position = Position.initial()
                .next(new Move(at("e2"), at("e4")))
                .next(new Move(at("d7"), at("d5")));
        assertTrue(rule.check(position, new Move(at("e4"), at("d5"))));
    }

    @Test
    void pawn_should_not_move_diagonally_without_capturing() {
        assertFalse(rule.check(Position.initial(), new Move(at("e2"), at("d3"))));
    }

    @Test
    void should_not_apply_to_other_pieces() {
        assertTrue(rule.check(Position.initial(), new Move(at("b1"), at("c3"))));
    }
}
