package software.ulpgc.chess.infrastructure;

import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import software.ulpgc.chess.application.ports.GameRepository;
import software.ulpgc.chess.application.ports.GameSerializer;
import software.ulpgc.chess.application.usecases.CreateGameUseCase;
import software.ulpgc.chess.infrastructure.adapters.InMemoryGameRepository;
import software.ulpgc.chess.infrastructure.adapters.JsonGameSerializer;
import software.ulpgc.chess.infrastructure.adapters.endpoints.CreateGameEndPoint;

public class Main {
    private static final GameRepository repository = new InMemoryGameRepository();
    private static final GameSerializer serializer = new JsonGameSerializer();

    static void main() {
        Javalin.create(config -> create(config))
                .start(8081);
    }

    private static void create(JavalinConfig config) {
        config.routes.post("/games", context -> CreateGameEndPoint.use(new CreateGameUseCase(repository, serializer), context).execute());
    }
}
