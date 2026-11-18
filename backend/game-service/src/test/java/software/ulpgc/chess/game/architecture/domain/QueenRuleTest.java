package software.ulpgc.chess.game.architecture.domain;

import org.junit.jupiter.api.Test;
import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Position;

import static org.junit.jupiter.api.Assertions.*;
import static software.ulpgc.chess.game.architecture.model.Square.at;

public class QueenRuleTest {
    private final Rule rule = new QueenRule();
    private final Position open = Position.initial().next(new Move(at("e2"), at("e4")));

    @Test
    void queen_should_move_diagonally_when_the_path_is_clear() {
        assertTrue(rule.check(open, new Move(at("d1"), at("h5"))));
    }

    @Test
    void queen_should_move_straight_when_the_path_is_clear() {
        Position position = open.next(new Move(at("d2"), at("d4")));
        assertTrue(rule.check(position, new Move(at("d1"), at("d3"))));
    }

    @Test
    void queen_should_not_jump_over_pieces() {
        assertFalse(rule.check(Position.initial(), new Move(at("d1"), at("d3"))));
    }

    @Test
    void queen_should_not_move_in_l_shape() {
        assertFalse(rule.check(open, new Move(at("d1"), at("e3"))));
    }

    @Test
    void should_not_apply_to_other_pieces() {
        assertTrue(rule.check(Position.initial(), new Move(at("e2"), at("e4"))));
    }
}
