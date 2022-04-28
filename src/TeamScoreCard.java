import java.util.List;

import static java.lang.Math.max;

public class TeamScoreCard {
    private int teamNumber;
    private int totalRuns;
    private int totalWickets;
    private final List<Player> players;
    private int strikerIndex;
    private int nonStrikerIndex;
    private int target;

    public TeamScoreCard(int teamNumber, List<Player> players,int target) {
        this.teamNumber=teamNumber;
        this.totalRuns = 0;
        this.totalWickets = 0;
        this.players = players;
        this.strikerIndex = 0;
        this.nonStrikerIndex = 1;
        this.target=target;
    }

    void ballExecute(String ballStatus) {
        switch (ballStatus) {
            case "W":
                players.get(strikerIndex).out();
                totalWickets++;
                strikerIndex = max(strikerIndex, nonStrikerIndex) + 1;
                break;
            case "Wd":
                totalRuns++;
                break;
            default:
                int run = Integer.parseInt(ballStatus);
                totalRuns+=run;
                players.get(strikerIndex).score(run);
                if (run % 2 != 0) {
                    int temp = strikerIndex;
                    strikerIndex = nonStrikerIndex;
                    nonStrikerIndex = temp;
                }
        }
    }

    public void lastBall(){
        int temp = strikerIndex;
        strikerIndex= nonStrikerIndex;
        nonStrikerIndex=temp;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getStrikerIndex() {
        return strikerIndex;
    }

    public int getNonStrikerIndex() {
        return nonStrikerIndex;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public int getTarget() {
        return target;
    }
}
