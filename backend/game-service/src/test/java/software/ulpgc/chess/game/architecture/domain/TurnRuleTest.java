package software.ulpgc.chess.game.architecture.domain;

import org.junit.jupiter.api.Test;
import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Position;

import static org.junit.jupiter.api.Assertions.*;
import static software.ulpgc.chess.game.architecture.model.Square.at;

public class TurnRuleTest {
    private final Rule rule = new TurnRule();

    @Test
    void white_should_move_first() {
        assertTrue(rule.check(Position.initial(), new Move(at("e2"), at("e4"))));
    }

    @Test
    void black_should_not_move_when_it_is_white_turn() {
        assertFalse(rule.check(Position.initial(), new Move(at("e7"), at("e5"))));
    }

    @Test
    void black_should_move_after_white() {
        Position position = Position.initial().next(new Move(at("e2"), at("e4")));
        assertTrue(rule.check(position, new Move(at("e7"), at("e5"))));
    }

    @Test
    void should_fail_when_there_is_no_piece() {
        assertFalse(rule.check(Position.initial(), new Move(at("e4"), at("e5"))));
    }
}
