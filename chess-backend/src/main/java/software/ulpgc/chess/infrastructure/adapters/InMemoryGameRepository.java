package software.ulpgc.chess.infrastructure.adapters;

import software.ulpgc.chess.application.domain.model.Game;
import software.ulpgc.chess.application.ports.GameRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryGameRepository implements GameRepository {
    private final Map<String, Game> games = new HashMap<>();

    @Override
    public void save(Game game) {
        games.put(game.id(), game);
    }
}
