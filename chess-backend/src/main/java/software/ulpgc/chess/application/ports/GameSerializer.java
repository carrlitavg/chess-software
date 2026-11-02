package software.ulpgc.chess.application.ports;

import software.ulpgc.chess.application.domain.model.Game;

public interface GameSerializer {
    String serialize(Game game);
}
