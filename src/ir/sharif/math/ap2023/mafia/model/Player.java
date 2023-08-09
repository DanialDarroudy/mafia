package ir.sharif.math.ap2023.mafia.model;


public abstract class Player {
    protected int id;
    protected String name;
    protected boolean alive = true;
    protected boolean mute = false;
    protected boolean heal = false;
    public int votedDay = 0;
    public int votedNight = 0;
    public boolean killedWithSniper = false;
    public boolean killedWithMafia = false;
    public boolean isExecute = false;
    public boolean healedWithDocLec = false;
    public boolean healedWithDoc = false;

    public Player(String name, int id) {
        this.id = id;
        this.name = name;
    }

    //----------------------------methods------------------------------//
    public abstract String action(Player target);

    public void vote(Player target) {
        target.votedDay++;
    }
    @Override
    public String toString(){
        return name;
    }

    //----------------------------methods------------------------------//
    //-----------------------------setter and getter----------------//


    public boolean isExecute() {
        return isExecute;
    }

    public void setExecute(boolean execute) {
        isExecute = execute;
    }

    public boolean isHealedWithDocLec() {
        return healedWithDocLec;
    }

    public void setHealedWithDocLec(boolean healedWithDocLec) {
        this.healedWithDocLec = healedWithDocLec;
    }

    public boolean isHealedWithDoc() {
        return healedWithDoc;
    }

    public void setHealedWithDoc(boolean healedWithDoc) {
        this.healedWithDoc = healedWithDoc;
    }

    public boolean isKilledWithMafia() {
        return killedWithMafia;
    }

    public void setKilledWithMafia(boolean killedWithMafia) {
        this.killedWithMafia = killedWithMafia;
    }

    public boolean isKilledWithSniper() {
        return killedWithSniper;
    }

    public void setKilledWithSniper(boolean killedWithSniper) {
        this.killedWithSniper = killedWithSniper;
    }

    public int getVotedNight() {
        return votedNight;
    }

    public void setVotedNight(int votedNight) {
        this.votedNight = votedNight;
    }

    public int getVotedDay() {
        return votedDay;
    }

    public void setVotedDay(int votedDay) {
        this.votedDay = votedDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    public boolean isHeal() {
        return heal;
    }

    public void setHeal(boolean heal) {
        this.heal = heal;
    }

    //-----------------------------setter and getter----------------//
}