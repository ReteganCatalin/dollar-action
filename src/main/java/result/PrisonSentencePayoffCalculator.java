package result;

import player.Choice;

import static player.Choice.BETRAY;
import static player.Choice.COOPERATE;
import static result.ResultType.*;

public class PrisonSentencePayoffCalculator implements PayoffCalculator {

    public static final float BOTH_COOPERATION_BONUS = 2f;
    public static final float BETRAYER_BONUS = 0f;
    public static final float BETRAYED_BONUS = 5f;
    public static final float BOTH_BETRAYED_BONUS = 3f;

    public RoundPayoff computePayoff(Choice p1choice, Choice p2Choice) {
        if (bothCooperate(p1choice, p2Choice)) {
            RoundPayoff payoff = RoundPayoff.init()
                    .playerPayoff(BOTH_COOPERATION_BONUS)
                    .computerPayoff(BOTH_COOPERATION_BONUS)
                    .build();
            payoff.setType(COOP_COOP);
            return payoff;
        } else if (firstCopperatesAndSecondBetrays(p1choice, p2Choice)) {
            RoundPayoff payoff = RoundPayoff.init()
                    .playerPayoff(BETRAYED_BONUS)
                    .computerPayoff(BETRAYER_BONUS)
                    .build();
            payoff.setType(COOP_BETRAY);
            return payoff;
        } else if (firstBetrayesAndSecondCooperates(p1choice, p2Choice)) {
            RoundPayoff payoff = RoundPayoff.init()
                    .playerPayoff(BETRAYER_BONUS)
                    .computerPayoff(BETRAYED_BONUS)
                    .build();
            payoff.setType(BETRAY_COOP);
            return payoff;
        } else if (bothBetrayed(p1choice, p2Choice)) {
            RoundPayoff payoff = RoundPayoff.init()
                    .playerPayoff(BOTH_BETRAYED_BONUS)
                    .computerPayoff(BOTH_BETRAYED_BONUS)
                    .build();
            payoff.setType(BETRAY_BETRAY);
            return payoff;
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
