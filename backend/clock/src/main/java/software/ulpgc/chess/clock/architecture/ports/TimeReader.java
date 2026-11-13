package software.ulpgc.chess.clock.architecture.ports;

import java.time.Instant;

public interface TimeReader {
    Instant now();
}
