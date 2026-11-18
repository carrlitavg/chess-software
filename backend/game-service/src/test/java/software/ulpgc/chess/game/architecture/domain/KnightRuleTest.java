package software.ulpgc.chess.game.architecture.domain;

import org.junit.jupiter.api.Test;
import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Position;

import static org.junit.jupiter.api.Assertions.*;
import static software.ulpgc.chess.game.architecture.model.Square.at;

public class KnightRuleTest {
    private final Rule rule = new KnightRule();

    @Test
    void knight_should_move_in_l_shape() {
        assertTrue(rule.check(Position.initial(), new Move(at("b1"), at("c3"))));
        assertTrue(rule.check(Position.initial(), new Move(at("g1"), at("e2"))));
    }

    @Test
    void knight_should_jump_over_pieces() {
        assertTrue(rule.check(Position.initial(), new Move(at("b1"), at("a3"))));
    }

    @Test
    void knight_should_not_move_straight() {
        assertFalse(rule.check(Position.initial(), new Move(at("b1"), at("b3"))));
    }

    @Test
    void knight_should_not_move_diagonally() {
        assertFalse(rule.check(Position.initial(), new Move(at("b1"), at("d3"))));
    }

    @Test
    void should_not_apply_to_other_pieces() {
        assertTrue(rule.check(Position.initial(), new Move(at("e2"), at("e4"))));
    }
}
