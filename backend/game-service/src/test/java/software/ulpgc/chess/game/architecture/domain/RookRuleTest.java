package software.ulpgc.chess.game.architecture.domain;

import org.junit.jupiter.api.Test;
import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Position;

import static org.junit.jupiter.api.Assertions.*;
import static software.ulpgc.chess.game.architecture.model.Square.at;

public class RookRuleTest {
    private final Rule rule = new RookRule();
    private final Position open = Position.initial().next(new Move(at("a2"), at("a4")));

    @Test
    void rook_should_move_straight_when_the_path_is_clear() {
        assertTrue(rule.check(open, new Move(at("a1"), at("a3"))));
    }

    @Test
    void rook_should_not_jump_over_pieces() {
        assertFalse(rule.check(Position.initial(), new Move(at("a1"), at("a3"))));
    }

    @Test
    void rook_should_not_move_diagonally() {
        assertFalse(rule.check(open, new Move(at("a1"), at("b2"))));
    }

    @Test
    void should_not_apply_to_other_pieces() {
        assertTrue(rule.check(Position.initial(), new Move(at("e2"), at("e4"))));
    }
}
