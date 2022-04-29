public class Match {
    private  int playerCount;
    private  int totalOvers;
    private Innings firstInnings;
    private Innings secondInnings;
    private int target;

    Match(int playerCount,int totalOvers,Team battingFirstTeam){
        this.playerCount = playerCount;
        this.totalOvers= totalOvers;
        this.firstInnings= new Innings(battingFirstTeam);
    }

    public void setSecondInnings(Team battingSecondTeam) {
        this.secondInnings = new Innings(battingSecondTeam);
    }

    void playFirstInnings(){
        firstInnings.playInnings(totalOvers,playerCount);
        this.target= firstInnings.getScoreCard().getTotalRuns();
    }

    void playSecondInnings(){
        secondInnings.playInnings(totalOvers,playerCount);
    }

    void decideWinner(){
        int team1Score= this.target;
        int team2Score = secondInnings.getScoreCard().getTotalRuns();
        String team1 = firstInnings.getBattingTeam().getTeamName();
        String team2 = secondInnings.getBattingTeam().getTeamName();
        if(team1Score>team2Score){
            System.out.println(team1+" has won the match by: "+(team1Score-team2Score)+" runs");
        }
        else if(team1Score<team2Score){
            System.out.println(team2+" has won the match by: "+(team2Score-team1Score)+" runs");
        }
        else {
            System.out.println("Match Drawn");
        }
    }

}
