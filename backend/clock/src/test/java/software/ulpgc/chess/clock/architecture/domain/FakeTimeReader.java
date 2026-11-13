package software.ulpgc.chess.clock.architecture.domain;

import software.ulpgc.chess.clock.architecture.ports.TimeReader;

import java.time.Duration;
import java.time.Instant;

public class FakeTimeReader implements TimeReader {
    private Instant now = Instant.parse("2026-01-01T12:00:00Z");

    @Override
    public Instant now() {
        return now;
    }

    public void advance(Duration time) {
        now = now.plus(time);
    }
}
