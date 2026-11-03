package software.ulpgc.chess.application.usecases;

import software.ulpgc.chess.application.UseCase;
import software.ulpgc.chess.application.domain.model.Game;
import software.ulpgc.chess.application.ports.GameRepository;
import software.ulpgc.chess.application.ports.GameSerializer;

import java.util.NoSuchElementException;

public class GetGameUseCase implements UseCase {
    private final GameRepository repository;
    private final GameSerializer serializer;

    public GetGameUseCase(GameRepository repository, GameSerializer serializer) {
        this.repository = repository;
        this.serializer = serializer;
    }

    @Override
    public String execute(String value) {
        return serializer.serialize(gameWith(value));
    }

    private Game gameWith(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Game " + id + " not found"));
    }
}
