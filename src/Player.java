public class Player {
    private final String playerName;
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

    public void scoreRun(int run){
        isBatting=true;
        switch (run) {
            case 4 -> fourCount++;
            case 6 -> sixCount++;
        }
        ballsFaced+=1;
        runs+=run;
    }

    public void getOut(){
        ballsFaced+=1;
        isBatting=false;
    }

    public void displayPlayerDetails(){
        String notOut= isBatting?"*":"";
        System.out.println("\t"+playerName+notOut+"\t\t"+runs+"\t\t"+ballsFaced+"\t\t"+
                fourCount +"\t\t"+sixCount);
    }
}
