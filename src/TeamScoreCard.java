import java.util.List;

import static java.lang.Math.max;

public class TeamScoreCard {
    private Team team;
    private int totalRuns;
    private int totalWickets;
    private int strikerIndex;
    private int nonStrikerIndex;

    public TeamScoreCard(Team team) {
        this.team=team;
        this.totalRuns = 0;
        this.totalWickets = 0;
        this.strikerIndex = 0;
        this.nonStrikerIndex = 1;
    }

    void updateScore(String ballStatus) {
        switch (ballStatus) {
            case "W" -> {
                team.getPlayers().get(strikerIndex).getOut();
                totalWickets++;
                strikerIndex = max(strikerIndex, nonStrikerIndex) + 1;
            }
            case "Wd" -> totalRuns++;
            default -> {
                int run = Integer.parseInt(ballStatus);
                totalRuns += run;
                team.getPlayers().get(strikerIndex).scoreRun(run);
                if (run % 2 != 0) {
                    int temp = strikerIndex;
                    strikerIndex = nonStrikerIndex;
                    nonStrikerIndex = temp;
                }
            }
        }
    }

    public void displayScoreCard(int overNumber, int lastBallPlayed){
        System.out.println("Scorecard for:"+team.getTeamName());
        System.out.println("PlayerName\tRuns\tBalls\tFours\tSixes");
        for(Player player:team.getPlayers()){
            player.displayPlayerDetails();
        }
        System.out.println("Total: "+totalRuns+"/"+totalWickets);
        if(lastBallPlayed%6==0)
            System.out.println("Overs: "+overNumber);
        else
            System.out.println("Overs: "+(overNumber-1)+"."+lastBallPlayed);
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
}
