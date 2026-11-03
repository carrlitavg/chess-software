package software.ulpgc.chess.infrastructure.adapters.endpoints;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import software.ulpgc.chess.application.UseCase;
import software.ulpgc.chess.infrastructure.adapters.EndPoint;

import java.util.NoSuchElementException;

public class GetGameEndPoint implements EndPoint {
    private final UseCase useCase;
    private final Context context;

    public GetGameEndPoint(UseCase useCase, Context context) {
        this.useCase = useCase;
        this.context = context;
    }

    public static EndPoint use(UseCase useCase, Context context) {
        return new GetGameEndPoint(useCase, context);
    }

    @Override
    public void execute() {
        try {
            context.contentType("application/json");
            context.result(useCase.execute(context.pathParam("id")));
        } catch (NoSuchElementException e) {
            context.status(HttpStatus.NOT_FOUND).result(e.getMessage());
        }
    }
}
