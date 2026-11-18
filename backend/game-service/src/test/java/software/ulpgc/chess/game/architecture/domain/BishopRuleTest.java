package software.ulpgc.chess.game.architecture.domain;

import org.junit.jupiter.api.Test;
import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Position;

import static org.junit.jupiter.api.Assertions.*;
import static software.ulpgc.chess.game.architecture.model.Square.at;

public class BishopRuleTest {
    private final Rule rule = new BishopRule();
    private final Position open = Position.initial().next(new Move(at("d2"), at("d4")));

    @Test
    void bishop_should_move_diagonally_when_the_path_is_clear() {
        assertTrue(rule.check(open, new Move(at("c1"), at("g5"))));
    }

    @Test
    void bishop_should_not_jump_over_pieces() {
        assertFalse(rule.check(Position.initial(), new Move(at("c1"), at("g5"))));
    }

    @Test
    void bishop_should_not_move_straight() {
        assertFalse(rule.check(open, new Move(at("c1"), at("c3"))));
    }

    @Test
    void should_not_apply_to_other_pieces() {
        assertTrue(rule.check(Position.initial(), new Move(at("e2"), at("e4"))));
    }
}
