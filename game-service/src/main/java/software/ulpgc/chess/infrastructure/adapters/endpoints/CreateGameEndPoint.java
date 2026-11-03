package software.ulpgc.chess.infrastructure.adapters.endpoints;

import io.javalin.http.Context;
import software.ulpgc.chess.application.UseCase;
import software.ulpgc.chess.infrastructure.adapters.EndPoint;

public class CreateGameEndPoint implements EndPoint {
    private final UseCase useCase;
    private final Context context;

    public CreateGameEndPoint(UseCase useCase, Context context) {
        this.useCase = useCase;
        this.context = context;
    }

    public static EndPoint use(UseCase useCase, Context context) {
        return new CreateGameEndPoint(useCase, context);
    }

    @Override
    public void execute() {
        context.contentType("application/json");
        context.result(useCase.execute(context.body()));
    }
}
