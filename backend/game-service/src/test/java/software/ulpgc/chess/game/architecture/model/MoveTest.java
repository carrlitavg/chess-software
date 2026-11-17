package software.ulpgc.chess.game.architecture.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static software.ulpgc.chess.game.architecture.model.Square.at;

public class MoveTest {
    @Test
    void should_know_its_distances() {
        Move move = new Move(at("b1"), at("c3"));
        assertEquals(1, move.fileDistance());
        assertEquals(2, move.rankDistance());
    }

    @Test
    void rank_shift_should_be_negative_when_moving_down() {
        assertEquals(2, new Move(at("e2"), at("e4")).rankShift());
        assertEquals(-2, new Move(at("e7"), at("e5")).rankShift());
    }

    @Test
    void should_know_if_it_is_straight() {
        assertTrue(new Move(at("a1"), at("a8")).isStraight());
        assertTrue(new Move(at("a1"), at("h1")).isStraight());
        assertFalse(new Move(at("a1"), at("b3")).isStraight());
    }

    @Test
    void should_know_if_it_is_diagonal() {
        assertTrue(new Move(at("c1"), at("h6")).isDiagonal());
        assertFalse(new Move(at("c1"), at("c6")).isDiagonal());
    }
}
