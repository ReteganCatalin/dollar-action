package round;

import lombok.Builder;
import player.Choice;
import player.Player;
import result.PayoffCalculator;

import java.util.Optional;

@Builder
public class Round {

    public static final long ROUNDS_PER_TOURNAMENT = 200;

    private final PayoffCalculator payoffCalculator;
    private final Player player1;
    private final Player player2;
    private final float OBJECT_VALUE = 100f;
    @Builder.Default
    private Choice p1Choice = Choice.BID;
    @Builder.Default
    private Choice p2Choice = Choice.BID;
    @Builder.Default
    private float p1CurrentBid = 0f;
    @Builder.Default
    private float p2CurrentBid = 0f;
    @Builder.Default
    private float p1LastBid = 0f;
    @Builder.Default
    private float p2LastBid = 0f;
    @Builder.Default
    private float bid = 0f;

    public void play() {
        for (int i = 0; i < ROUNDS_PER_TOURNAMENT; i++) {
            if (i % 2 == 0) {
                playRound();
            } else {
                if (secondPlayerBidsFirst()) {
                    playRound();
                }
            }
        }
        savePoints();
        reset();
    }

    private void savePoints() {
        player1.savePoints(player2);
        player2.savePoints(player1);
    }

    private void reset() {
        player1.reset();
        player2.reset();
    }

    private void playRound() {
        while (bid < 1000f) {
            if (playBiddingRound()) return;
        }
        if (p1CurrentBid > p2CurrentBid) {
            p2Choice = Choice.STOP;
        } else {
            p1Choice = Choice.STOP;
        }
        endRound(p1Choice, p2Choice, p1CurrentBid, p2CurrentBid, bid);
    }

    private boolean secondPlayerBidsFirst() {
        p2CurrentBid = Optional.of(player2.play(bid)).orElse(randomChoice(bid));
        if (p2CurrentBid <= bid) {
            p2Choice = Choice.STOP;
            endRound(p1Choice, p2Choice, p1LastBid, p2LastBid, bid);
            return false;
        } else {
            bid = p2CurrentBid;
            p2LastBid = p2CurrentBid;
            player1.addOpponentBid(p2CurrentBid);
            return true;
        }
    }

    private boolean playBiddingRound() {
        p1CurrentBid = Optional.of(player1.play(bid)).orElse(randomChoice(bid));
        if (p1CurrentBid <= bid) {
            p1Choice = Choice.STOP;
            endRound(p1Choice, p2Choice, p1LastBid, p2LastBid, bid);
            return true;
        } else {
            bid = p1CurrentBid;
            p1LastBid = p1CurrentBid;
            player2.addOpponentBid(p1CurrentBid);
            p2CurrentBid = Optional.of(player2.play(bid)).orElse(randomChoice(bid));

            if (p2CurrentBid <= bid) {
                p2Choice = Choice.STOP;
                endRound(p1Choice, p2Choice, p1LastBid, p2LastBid, bid);
                return true;
            } else {
                bid = p2CurrentBid;
                player1.addOpponentBid(p2CurrentBid);
                p2LastBid = p2CurrentBid;
            }
        }
        return false;
    }

    private void endRound(Choice p1Choice, Choice p2Choice, float p1Bid, float p2Bid, float winningBid) {
        player1.addOpponentMaxBid(p2Bid);
        player1.addWinningBid(winningBid);
        player1.resetRound();
        player2.addOpponentMaxBid(p1Bid);
        player2.addWinningBid(winningBid);
        player2.resetRound();
        payoffCalculator.payoffPlayers(player1, p1Choice, p1Bid, player2, p2Choice, p2Bid, OBJECT_VALUE);
        resetVariables();
    }

    private void resetVariables() {
        p1Choice = Choice.BID;
        p2Choice = Choice.BID;
        p1CurrentBid = 0f;
        p2CurrentBid = 0f;
        p1LastBid = 0f;
        p2LastBid = 0f;
        bid = 0f;
    }

    private float randomChoice(float bid) {
        Choice result = Choice.random();
        if (result == Choice.BID) {
            return bid + 5f;
        } else {
            return bid + 0f;
        }
    }
}
