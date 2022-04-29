import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cricket_Driver {
    static int playerCount=0;
    public static void main(String[] args){
        System.out.println("Enter the number of player in each team");
       Scanner sc = new Scanner(System.in);
       String playerCountString = sc.nextLine();
       playerCount = Integer.parseInt(playerCountString);

       System.out.println("Enter the number of overs");
       String overCountString = sc.nextLine();
       int overCount = Integer.parseInt(overCountString);


       System.out.println("Please enter the batting order of Team 1");
       List<Player> team1Players = inputTeamDetails();
       TeamScoreCard team1TeamScoreCard = new TeamScoreCard(1,team1Players,0);
       playInnings(team1TeamScoreCard,overCount,playerCount);
        int team1Score = team1TeamScoreCard.getTotalRuns();

        System.out.println("Please enter the batting order of Team 2");
        List<Player> team2Players =  inputTeamDetails();
        TeamScoreCard team2TeamScoreCard = new TeamScoreCard(2,team2Players,team1Score);
        playInnings(team2TeamScoreCard,overCount,playerCount);
        int team2Score = team2TeamScoreCard.getTotalRuns();

        decideWinner(team1Score,team2Score);

    }

    public static void displayScore(TeamScoreCard teamScoreCard, int overNumber, int lastBallPlayed){
        int teamNumber = teamScoreCard.getTeamNumber();
        System.out.println("Scorecard for Team "+teamNumber);
        System.out.println("PlayerName\tRuns\tBalls\tFours\tSixes");

        for(Player player:teamScoreCard.getPlayers()){
            String notOut= player.isBatting()?"*":"";
            System.out.println("\t"+player.getPlayer()+notOut+"\t\t"+player.getRuns()+"\t\t"+player.getBallsFaced()+"\t\t"+
                    player.getFourCount() +"\t\t"+player.getSixCount());
        }
        System.out.println("Total: "+teamScoreCard.getTotalRuns()+"/"+teamScoreCard.getTotalWickets());
        if(lastBallPlayed%6==0)
            System.out.println("Overs: "+overNumber);
        else
            System.out.println("Overs: "+(overNumber-1)+"."+lastBallPlayed);
    }

    public static void playInnings(TeamScoreCard battingTeam, int overCount, int playerCount){
        Scanner sc = new Scanner(System.in);
        int currentOver=1;
        for(;currentOver<=overCount;currentOver++){
            int currentBall=1;
            while (currentBall<=6) {
                System.out.println("Enter Ball Status for Ball No:"+currentOver+" for over: "+currentBall);
                String ballStatus = sc.nextLine();
                battingTeam.ballExecute(ballStatus);
                if(currentBall==6){
                    battingTeam.lastBall();
                }
                if(!ballStatus.equals("Wd"))
                    ++currentBall;
                if(battingTeam.getTotalWickets()==(playerCount-1))
                    break;
                if(battingTeam.getTeamNumber()==2 && battingTeam.getTotalRuns()>battingTeam.getTarget())
                    break;
            }
            displayScore(battingTeam,currentOver,currentBall-1);
        }
    }

    public static List<Player> inputTeamDetails(){
        Scanner sc = new Scanner(System.in);
        List<Player> teamPlayers = new ArrayList<>();
        for(int i=0;i<playerCount;i++){
            String playerName = sc.nextLine();
            Player player= new Player(playerName);
            teamPlayers.add(player);
        }
        return teamPlayers;
    }

    public static void decideWinner(int team1Score,int team2Score){
        if(team1Score>team2Score){
            System.out.println("Team 1 has won the match by: "+(team1Score-team2Score)+" runs");
        }
        else if(team1Score<team2Score){
            System.out.println("Team 2 has won the match by: "+(team2Score-team1Score)+" runs");
        }
        else {
            System.out.println("Match Drawn");
        }
    }
}
