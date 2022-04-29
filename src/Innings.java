import java.util.Scanner;

public class Innings {
     private Team battingTeam;
     private TeamScoreCard scoreCard;

    public Innings(Team battingTeam){
        this.battingTeam=battingTeam;
        this.scoreCard = new TeamScoreCard(battingTeam);
    }

    void playInnings(int totalOvers,int playerCount,int target){
        Scanner sc = new Scanner(System.in);
        int currentOver=1;
        boolean isMatchOver=false;
        for(;currentOver<=totalOvers;currentOver++){
            int currentBall=0;
            while (true) {
                System.out.println("Enter Ball Status for Over No:"+currentOver+" for Ball: "+(currentBall+1));
                String ballStatus = sc.nextLine();
                if(ballStatus.length()==3){
                    --currentBall;
                }
                ++currentBall;
                scoreCard.updateScore(ballStatus);
                if(scoreCard.getTotalWickets()==(playerCount-1)) {
                    isMatchOver= true;
                    break;
                }
                if(target!=-1 && scoreCard.getTotalRuns()>target){
                    isMatchOver= true;
                    break;
                }
                if(currentBall==MatchConstants.BALL_COUNT){
                    scoreCard.lastBall();
                    break;
                }


            }
            scoreCard.displayScoreCard(currentOver,currentBall);
            if(isMatchOver){
                break;
            }
        }
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public TeamScoreCard getScoreCard() {
        return scoreCard;
    }
}
