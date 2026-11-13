package software.ulpgc.chess.clock.architecture.model;

import software.ulpgc.chess.game.architecture.model.Color;

import java.time.Duration;
import java.time.Instant;

import static software.ulpgc.chess.game.architecture.model.Color.White;

public record ClockState(Duration white, Duration black, Color turn, Instant turnStart) {
    public static ClockState start(ClockMode mode, Instant now) {
        return new ClockState(mode.initialTime(), mode.initialTime(), White, now);
    }

    public Duration remaining() {
        if (turn == White) {
            return white;
        } else {
            return black;
        }
    }
}
