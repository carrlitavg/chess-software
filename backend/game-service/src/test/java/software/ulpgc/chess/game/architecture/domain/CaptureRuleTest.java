package software.ulpgc.chess.game.architecture.domain;

import org.junit.jupiter.api.Test;
import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Position;

import static org.junit.jupiter.api.Assertions.*;
import static software.ulpgc.chess.game.architecture.model.Square.at;

public class CaptureRuleTest {
    private final Rule rule = new CaptureRule();

    @Test
    void should_move_to_an_empty_square() {
        assertTrue(rule.check(Position.initial(), new Move(at("e2"), at("e4"))));
    }

    @Test
    void should_capture_a_piece_of_the_other_color() {
        assertTrue(rule.check(Position.initial(), new Move(at("d1"), at("d7"))));
    }

    @Test
    void should_not_capture_a_piece_of_its_own_color() {
        assertFalse(rule.check(Position.initial(), new Move(at("d1"), at("d2"))));
    }

    @Test
    void should_not_stay_in_the_same_square() {
        assertFalse(rule.check(Position.initial(), new Move(at("e2"), at("e2"))));
    }
}
