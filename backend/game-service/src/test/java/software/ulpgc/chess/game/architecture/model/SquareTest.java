package software.ulpgc.chess.game.architecture.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static software.ulpgc.chess.game.architecture.model.File.*;
import static software.ulpgc.chess.game.architecture.model.Rank.*;

class SquareTest {
    @Test
    void should_parse_a_square() {
        assertEquals(new Square(E, R4), Square.at("e4"));
    }

    @Test
    void should_parse_the_corners() {
        assertEquals(new Square(A, R1), Square.at("a1"));
        assertEquals(new Square(H, R8), Square.at("h8"));
    }

    @Test
    void should_fail_with_a_file_out_of_the_board() {
        assertThrows(Square.ParseException.class, () -> Square.at("i4"));
    }

    @Test
    void should_fail_with_a_rank_out_of_the_board() {
        assertThrows(Square.ParseException.class, () -> Square.at("e9"));
    }

    @Test
    void should_fail_with_a_wrong_length() {
        assertThrows(Square.ParseException.class, () -> Square.at("e44"));
    }

    @Test
    void should_fail_with_null() {
        assertThrows(Square.ParseException.class, () -> Square.at(null));
    }

    @Test
    void should_know_its_indexes() {
        assertEquals(4, Square.at("e4").fileIndex());
        assertEquals(3, Square.at("e4").rankIndex());
    }

    @Test
    void should_step_towards_another_square() {
        assertEquals(Square.at("e2"), Square.at("e1").towards(Square.at("e8")));
        assertEquals(Square.at("b2"), Square.at("a1").towards(Square.at("h8")));
        assertEquals(Square.at("g7"), Square.at("h8").towards(Square.at("a1")));
    }
}
