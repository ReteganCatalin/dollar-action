package result;

import player.Choice;

import static player.Choice.BETRAY;
import static player.Choice.COOPERATE;

public class RoundPayoffCalculator {

    public static final int BOTH_COOPERATION_BONUS = 75;
    public static final int BETRAYER_BONUS = 85;
    public static final int BETRAYED_BONUS = 25;
    public static final int BOTH_BETRAYED_BONUS = 30;

    public RoundPayoff computePayoff(Choice p1choice, Choice p2Choice) {
        if (bothCooperate(p1choice, p2Choice)) {
            return RoundPayoff.builder()
                    .p1payoff(BOTH_COOPERATION_BONUS)
                    .p2payoff(BOTH_COOPERATION_BONUS)
                    .build();
        } else if (firstCopperatesAndSecondBetrays(p1choice, p2Choice)) {
            return RoundPayoff.builder()
                    .p1payoff(BETRAYED_BONUS)
                    .p2payoff(BETRAYER_BONUS)
                    .build();
        } else if (firstBetrayesAndSecondCooperates(p1choice, p2Choice)) {
            return RoundPayoff.builder()
                    .p1payoff(BETRAYER_BONUS)
                    .p2payoff(BETRAYED_BONUS)
                    .build();
        } else if (bothBetrayed(p1choice, p2Choice)) {
            return RoundPayoff.builder()
                    .p1payoff(BOTH_BETRAYED_BONUS)
                    .p2payoff(BOTH_BETRAYED_BONUS)
                    .build();
        }
        throw new RuntimeException("Wtf?");
    }

    private boolean bothCooperate(Choice p1choice, Choice p2Choice) {
        return p1choice.equals(COOPERATE) && p2Choice.equals(COOPERATE);
    }

    private boolean firstCopperatesAndSecondBetrays(Choice p1choice, Choice p2Choice) {
        return p1choice.equals(COOPERATE) && p2Choice.equals(BETRAY);
    }


    private boolean firstBetrayesAndSecondCooperates(Choice p1choice, Choice p2Choice) {
        return p1choice.equals(BETRAY) && p2Choice.equals(COOPERATE);
    }

    private boolean bothBetrayed(Choice p1choice, Choice p2Choice) {
        return p1choice.equals(BETRAY) && p2Choice.equals(BETRAY);
    }
}
