package software.ulpgc.chess.clock.architecture.domain;

import org.junit.jupiter.api.Test;
import software.ulpgc.chess.clock.architecture.model.ClockState;

import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;
import static software.ulpgc.chess.clock.architecture.model.ClockMode.*;
import static software.ulpgc.chess.game.architecture.model.Color.Black;
import static software.ulpgc.chess.game.architecture.model.Color.White;

class ClockOperatorTest {
    private final FakeTimeReader timeReader = new FakeTimeReader();
    private final ClockOperator blitz = new ClockOperator(Blitz, timeReader);

    @Test
    void start_should_give_both_players_the_initial_time() {
        ClockState state = blitz.start();
        assertEquals(ofMinutes(3), state.white());
        assertEquals(ofMinutes(3), state.black());
    }

    @Test
    void start_should_give_the_turn_to_white() {
        assertEquals(White, blitz.start().turn());
    }

    @Test
    void press_should_subtract_the_time_spent() {
        ClockState state = blitz.start();
        timeReader.advance(ofSeconds(30));
        assertEquals(ofSeconds(152), blitz.press(state).white());
    }

    @Test
    void press_should_add_the_increment() {
        ClockState state = blitz.start();
        assertEquals(ofSeconds(182), blitz.press(state).white());
    }

    @Test
    void press_should_change_the_turn() {
        ClockState state = blitz.press(blitz.start());
        assertEquals(Black, state.turn());
        assertEquals(White, blitz.press(state).turn());
    }

    @Test
    void press_should_not_change_the_time_of_the_other_player() {
        ClockState state = blitz.start();
        timeReader.advance(ofSeconds(30));
        assertEquals(ofMinutes(3), blitz.press(state).black());
    }

    @Test
    void remaining_should_be_the_time_of_the_player_with_the_turn() {
        ClockState state = blitz.start();
        timeReader.advance(ofSeconds(30));
        assertEquals(ofMinutes(3), blitz.press(state).remaining());
    }

    @Test
    void press_without_time_left_should_throw_time_out_exception() {
        ClockOperator bullet = new ClockOperator(Bullet, timeReader);
        ClockState state = bullet.start();
        timeReader.advance(ofMinutes(1));
        assertThrows(TimeOutException.class, () -> bullet.press(state));
    }

    @Test
    void is_time_out_should_be_false_while_there_is_time_left() {
        ClockState state = blitz.start();
        timeReader.advance(ofMinutes(2));
        assertFalse(blitz.isTimeOut(state));
    }

    @Test
    void is_time_out_should_be_true_when_the_time_is_over() {
        ClockState state = blitz.start();
        timeReader.advance(ofMinutes(3));
        assertTrue(blitz.isTimeOut(state));
    }
}
