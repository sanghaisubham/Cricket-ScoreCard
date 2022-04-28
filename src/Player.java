public class Player {

    private String playerName;
    private int runs;
    private int ballsFaced;
    private int fourCount;
    private int sixCount;
    private boolean isBatting;

    public Player(String player) {
        this.playerName = player;
        this.ballsFaced=0;
        this.runs=0;
        this.fourCount=0;
        this.sixCount=0;
        this.isBatting=false;
    }

    public float strikeRate(){
        return (this.runs/this.ballsFaced)*100;
    }

    public String getPlayer() {
        return playerName;
    }

    public void score(int run){
        isBatting=true;
        switch (run){
            case 4:
                fourCount++;
                break;
            case 6:
                sixCount++;
                break;
        }
        ballsFaced+=1;
        runs+=run;
    }

    public void out(){
        ballsFaced+=1;
        isBatting=false;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getRuns() {
        return runs;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public int getFourCount() {
        return fourCount;
    }

    public int getSixCount() {
        return sixCount;
    }

    public boolean isBatting() {
        return isBatting;
    }
}
