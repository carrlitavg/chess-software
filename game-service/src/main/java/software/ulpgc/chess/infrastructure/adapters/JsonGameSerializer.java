package software.ulpgc.chess.infrastructure.adapters;

import com.google.gson.Gson;
import software.ulpgc.chess.application.domain.model.Board;
import software.ulpgc.chess.application.domain.model.Game;
import software.ulpgc.chess.application.domain.model.Move;
import software.ulpgc.chess.application.domain.model.Square;
import software.ulpgc.chess.application.ports.GameSerializer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class JsonGameSerializer implements GameSerializer {
    private final Gson gson = new Gson();

    @Override
    public String serialize(Game game) {
        return gson.toJson(toMap(game));
    }

    private Map<String, Object> toMap(Game game) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", game.id());
        map.put("status", game.status().name());
        map.put("turn", game.turn().name());
        map.put("board", boardOf(game.board()));
        map.put("moves", movesOf(game.moves()));
        return map;
    }

    private Map<String, String> boardOf(Board board) {
        return board.pieces().entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> nameOf(entry.getKey()),
                        entry -> entry.getValue().name(),
                        (first, second) -> first,
                        TreeMap::new));
    }

    private List<String> movesOf(List<Move> moves) {
        return moves.stream()
                .map(move -> nameOf(move.from()) + nameOf(move.to()))
                .toList();
    }

    private String nameOf(Square square) {
        return "" + square.file().symbol() + square.rank().value();
    }
}
