package ir.sharif.math.ap2023.mafia.model;

public class OrdinaryMafia extends Mafia{

    public OrdinaryMafia(String name, int id) {
        super(name, id);
    }

    //---------------------------methods-------------------------//

    @Override
    public String action(Player target) {
        target.votedNight++;
        return "";
    }
    @Override
    public String toString(){
        return name;
    }
    //---------------------------methods-------------------------//
    //-----------------------------setter and getter----------------//

    //-----------------------------setter and getter----------------//
}