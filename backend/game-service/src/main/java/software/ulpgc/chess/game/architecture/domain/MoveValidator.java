package software.ulpgc.chess.game.architecture.domain;

import software.ulpgc.chess.game.architecture.model.Move;
import software.ulpgc.chess.game.architecture.model.Position;

import java.util.List;

public class MoveValidator {
    private final Position position;
    private final List<Rule> rules;

    public MoveValidator(Position position, List<Rule> rules) {
        this.position = position;
        this.rules = rules;
    }

    public boolean isValid(Move move) {
        return rules.stream().allMatch(rule -> rule.check(position, move));
    }
}
