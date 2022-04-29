import java.util.Scanner;

public class Innings {
     private Team battingTeam;
     private TeamScoreCard scoreCard;

    public Innings(Team battingTeam){
        this.battingTeam=battingTeam;
        this.scoreCard = new TeamScoreCard(battingTeam);
    }

    void playInnings(int totalOvers,int playerCount){
        Scanner sc = new Scanner(System.in);
        int currentOver=1;
        for(;currentOver<=totalOvers;currentOver++){
            int currentBall=1;
            while (true) {
                System.out.println("Enter Ball Status for Over No:"+currentOver+" for Ball: "+currentBall);
                String ballStatus = sc.nextLine();
                scoreCard.updateScore(ballStatus);
                if(currentBall==MatchConstants.BALL_COUNT){
                    scoreCard.lastBall();
                    break;
                }
                if(scoreCard.getTotalWickets()==(playerCount-1))
                    break;
                if(!ballStatus.equals("Wd"))
                    ++currentBall;
            }
            scoreCard.displayScoreCard(currentOver,currentBall);
        }
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public TeamScoreCard getScoreCard() {
        return scoreCard;
    }
}
