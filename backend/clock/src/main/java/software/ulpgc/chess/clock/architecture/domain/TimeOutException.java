package software.ulpgc.chess.clock.architecture.domain;

public class TimeOutException extends RuntimeException {
    public TimeOutException(String message) {
        super(message);
    }
}
