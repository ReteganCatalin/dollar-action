package player;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Round {
    private Choice p1choice;
    private Choice p2choice;
}
