package software.ulpgc.chess.application.usecases;

import software.ulpgc.chess.application.UseCase;
import software.ulpgc.chess.application.domain.model.Game;
import software.ulpgc.chess.application.ports.GameRepository;
import software.ulpgc.chess.application.ports.GameSerializer;

import java.util.UUID;

public class CreateGameUseCase implements UseCase {
    private final GameRepository repository;
    private final GameSerializer serializer;

    public CreateGameUseCase(GameRepository repository, GameSerializer serializer) {
        this.repository = repository;
        this.serializer = serializer;
    }

    @Override
    public String execute(String value) {
        Game game = Game.start(newId());
        repository.save(game);
        return serializer.serialize(game);
    }

    private String newId() {
        return UUID.randomUUID().toString();
    }
}
