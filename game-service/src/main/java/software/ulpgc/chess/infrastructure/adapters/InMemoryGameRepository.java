package software.ulpgc.chess.infrastructure.adapters;

import software.ulpgc.chess.application.domain.model.Game;
import software.ulpgc.chess.application.ports.GameRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryGameRepository implements GameRepository {
    private final Map<String, Game> games = new HashMap<>();

    @Override
    public void save(Game game) {
        games.put(game.id(), game);
    }

    @Override
    public Optional<Game> findById(String id) {
        return Optional.ofNullable(games.get(id));
    }
}
