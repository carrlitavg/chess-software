package software.ulpgc.chess.clock.infrastructure.adapters;

import software.ulpgc.chess.clock.architecture.ports.TimeReader;

import java.time.Instant;

public class SystemTimeReader implements TimeReader {
    @Override
    public Instant now() {
        return Instant.now();
    }
}
