package ohtu;

public class TennisGame {

    private int player1score = 0;
    private int player2score = 0;
    private final String player1;
    private final String player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = player1Name;
        this.player2 = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1score += 1;
        } else {
            player2score += 1;
        }
    }

    public String getScore() {
        if (tie()) {
            return buildEvenScore();
        } else if (tieBreak()) {
            return buildTieBreakScore();
        } else {
            return buildScore();
        }
    }

    private String buildEvenScore() {
        if (player1score < 4) {
            return scoreToText(player1score) + "-All";
        } else {
            return "Deuce";
        }
    }

    private String buildTieBreakScore() {
        int diff = player1score - player2score;
        if (diff == 1) {
            return "Advantage player1";
        } else if (diff == -1) {
            return "Advantage player2";
        } else if (diff >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String buildScore() {
        return scoreToText(player1score) + "-" + scoreToText(player2score);
    }

    private String scoreToText(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private boolean tie() {
        return player1score == player2score;
    }

    private boolean tieBreak() {
        return player1score >= 4 || player2score >= 4;
    }
}
