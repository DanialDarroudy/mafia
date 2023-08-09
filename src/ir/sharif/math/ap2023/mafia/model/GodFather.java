package ir.sharif.math.ap2023.mafia.model;

public class GodFather extends Mafia {
    public boolean asked = false;

    public GodFather(String name, int id) {
        super(name, id);
    }
    //---------------------------methods-------------------------//
    public void asked(){
            this.asked = true;
    }
    @Override
    public String toString(){
        return name;
    }
    @Override
    public String action(Player target) {
        target.votedNight += 1000;
        return "";
    }
    //---------------------------methods-------------------------//
    //-----------------------------setter and getter----------------//
    public boolean isAsked() {
        return asked;
    }

    public void setAsked(boolean asked) {
        this.asked = asked;
    }
    //-----------------------------setter and getter----------------//
}