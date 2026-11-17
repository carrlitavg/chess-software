package software.ulpgc.chess.game.architecture.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static software.ulpgc.chess.game.architecture.model.Piece.*;
import static software.ulpgc.chess.game.architecture.model.Square.at;

class BoardTest {
    @Test
    void initial_board_should_have_32_pieces() {
        assertEquals(32, Board.initial().pieces().size());
    }

    @Test
    void initial_board_should_have_the_kings_in_place() {
        assertEquals(WhiteKing, Board.initial().pieceAt("e1"));
        assertEquals(BlackKing, Board.initial().pieceAt("e8"));
    }

    @Test
    void move_should_place_the_piece_in_the_target_square() {
        Board board = Board.initial().move(at("e2"), at("e4"));
        assertEquals(WhitePawn, board.pieceAt("e4"));
        assertNull(board.pieceAt("e2"));
    }

    @Test
    void move_should_capture_the_piece_in_the_target_square() {
        Board board = Board.initial().move(at("d1"), at("d7"));
        assertEquals(WhiteQueen, board.pieceAt("d7"));
        assertEquals(31, board.pieces().size());
    }

    @Test
    void move_should_not_change_the_original_board() {
        Board board = Board.initial();
        board.move(at("e2"), at("e4"));
        assertEquals(Board.initial(), board);
    }

    @Test
    void path_should_be_clear_when_no_pieces_in_between() {
        assertTrue(Board.initial().isPathClear(at("a2"), at("a7")));
        assertTrue(Board.initial().isPathClear(at("e1"), at("e2")));
    }

    @Test
    void path_should_not_be_clear_when_a_piece_is_in_between() {
        assertFalse(Board.initial().isPathClear(at("a1"), at("a8")));
        assertFalse(Board.initial().isPathClear(at("c1"), at("h6")));
    }
}
