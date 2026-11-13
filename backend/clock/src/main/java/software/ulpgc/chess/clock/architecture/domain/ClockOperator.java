package software.ulpgc.chess.clock.architecture.domain;

import software.ulpgc.chess.clock.architecture.model.ClockMode;
import software.ulpgc.chess.clock.architecture.model.ClockState;
import software.ulpgc.chess.clock.architecture.ports.TimeReader;

import java.time.Duration;
import java.time.Instant;

import static software.ulpgc.chess.game.architecture.model.Color.Black;
import static software.ulpgc.chess.game.architecture.model.Color.White;

public class ClockOperator {
    private final ClockMode mode;
    private final TimeReader timeReader;

    public ClockOperator(ClockMode mode, TimeReader timeReader) {
        this.mode = mode;
        this.timeReader = timeReader;
    }

    public ClockState start() {
        return ClockState.start(mode, timeReader.now());
    }

    public ClockState press(ClockState state) {
        Instant now = timeReader.now();
        Duration left = timeLeft(state, now);
        if (isOver(left)) {
            throw new TimeOutException(state.turn() + " has no time left");
        }
        return nextTurn(state, left.plus(mode.increment()), now);
    }

    public boolean isTimeOut(ClockState state) {
        return isOver(timeLeft(state, timeReader.now()));
    }

    private Duration timeLeft(ClockState state, Instant now) {
        return state.remaining().minus(Duration.between(state.turnStart(), now));
    }

    private boolean isOver(Duration left) {
        return left.isNegative() || left.isZero();
    }

    private ClockState nextTurn(ClockState state, Duration left, Instant now) {
        if (state.turn() == White) {
            return new ClockState(left, state.black(), Black, now);
        } else {
            return new ClockState(state.white(), left, White, now);
        }
    }
}
