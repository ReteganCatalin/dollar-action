package result;

import player.Choice;

public class PrisonSentencePayoffCalculator implements PayoffCalculator {

    public static final float BOTH_COOPERATION_BONUS = 2f;
    public static final float BETRAYER_BONUS = 0f;
    public static final float BETRAYED_BONUS = 5f;
    public static final float BOTH_BETRAYED_BONUS = 3f;

    public RoundPayoff computePayoff(Choice player, Choice computer, ResultType type) {
        RoundPayoff payoff = RoundPayoff.empty();

        if (bothCooperate(player, computer)) {
            payoff = RoundPayoff.init()
                    .playerPayoff(BOTH_COOPERATION_BONUS)
                    .computerPayoff(BOTH_COOPERATION_BONUS)
                    .build();
        } else if (firstCopperatesAndSecondBetrays(player, computer)) {
            payoff = RoundPayoff.init()
                    .playerPayoff(BETRAYED_BONUS)
                    .computerPayoff(BETRAYER_BONUS)
                    .build();
        } else if (firstBetrayesAndSecondCooperates(player, computer)) {
            payoff = RoundPayoff.init()
                    .playerPayoff(BETRAYER_BONUS)
                    .computerPayoff(BETRAYED_BONUS)
                    .build();
        } else if (bothBetrayed(player, computer)) {
            payoff = RoundPayoff.init()
                    .playerPayoff(BOTH_BETRAYED_BONUS)
                    .computerPayoff(BOTH_BETRAYED_BONUS)
                    .build();
        }
        payoff.setType(type);
        return payoff;
    }

    private boolean bothCooperate(Choice player, Choice computer) {
        return player.cooperates() && computer.cooperates();
    }

    private boolean firstCopperatesAndSecondBetrays(Choice player, Choice computer) {
        return player.cooperates() && computer.betrays();
    }


    private boolean firstBetrayesAndSecondCooperates(Choice player, Choice computer) {
        return player.betrays() && computer.cooperates();
    }

    private boolean bothBetrayed(Choice player, Choice computer) {
        return player.betrays() && computer.betrays();
    }
}
