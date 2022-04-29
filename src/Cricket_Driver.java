import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cricket_Driver {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Enter the number of player in each team");
       String playerCountString = sc.nextLine();
       int playerCount = Integer.parseInt(playerCountString);

       System.out.println("Enter the number of overs");
       String overCountString = sc.nextLine();
       int overCount = Integer.parseInt(overCountString);

       Team battingFirstTeam = new Team("Team1");
       battingFirstTeam.inputTeamDetails(playerCount);
       Match match = new Match(playerCount,overCount,battingFirstTeam);
       match.playFirstInnings();

       Team battingSecondTeam = new Team("Team2");
        battingSecondTeam.inputTeamDetails(playerCount);
       match.setSecondInnings(battingSecondTeam);
       match.playSecondInnings();

       match.decideWinner();
    }



}
