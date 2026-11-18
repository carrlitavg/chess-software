package software.ulpgc.chess.game.architecture.domain;

import org.junit.jupiter.api.Test;
import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Position;

import static org.junit.jupiter.api.Assertions.*;
import static software.ulpgc.chess.game.architecture.model.Square.at;

public class KingRuleTest {
    private final Rule rule = new KingRule();

    @Test
    void king_should_move_one_square_in_any_direction() {
        assertTrue(rule.check(Position.initial(), new Move(at("e1"), at("e2"))));
        assertTrue(rule.check(Position.initial(), new Move(at("e1"), at("f2"))));
        assertTrue(rule.check(Position.initial(), new Move(at("e1"), at("d1"))));
    }

    @Test
    void king_should_not_move_two_squares() {
        assertFalse(rule.check(Position.initial(), new Move(at("e1"), at("e3"))));
        assertFalse(rule.check(Position.initial(), new Move(at("e1"), at("g1"))));
    }

    @Test
    void should_not_apply_to_other_pieces() {
        assertTrue(rule.check(Position.initial(), new Move(at("e2"), at("e4"))));
    }
}
