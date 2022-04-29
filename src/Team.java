import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Team {
    private String teamName;
    private List<Player> players;

    public Team(String teamName) {
        this.teamName = teamName;
    }
    public String getTeamName() {
        return teamName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    void inputTeamDetails(int playerCount){
        System.out.println("Please enter the batting order of: "+teamName);
        Scanner sc = new Scanner(System.in);
        List<Player> teamPlayers = new ArrayList<>();
        for(int i=0;i<playerCount;i++){
            String playerName = sc.nextLine();
            Player player= new Player(playerName);
            teamPlayers.add(player);
        }
        this.players= teamPlayers;
    }
}
