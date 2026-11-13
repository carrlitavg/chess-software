package software.ulpgc.chess.clock.architecture.model;

import java.time.Duration;

import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;

public enum ClockMode {
    Bullet(ofMinutes(1), ofSeconds(0)),
    Blitz(ofMinutes(3), ofSeconds(2)),
    Rapid(ofMinutes(10), ofSeconds(5)),
    Classical(ofMinutes(90), ofSeconds(30));

    private final Duration initialTime;
    private final Duration increment;

    ClockMode(Duration initialTime, Duration increment) {
        this.initialTime = initialTime;
        this.increment = increment;
    }

    public Duration initialTime() {
        return initialTime;
    }

    public Duration increment() {
        return increment;
    }
}
