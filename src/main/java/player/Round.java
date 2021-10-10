package player;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Round {
    private Choice playerChoice;
    private Choice computerChoice;

    public static Round random() {
        return Round.builder().playerChoice(Choice.random()).computerChoice(Choice.random()).build();
    }
}
