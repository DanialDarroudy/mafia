package ir.sharif.math.ap2023.mafia.model;

public class OrdinaryCitizen extends Citizen {
    public OrdinaryCitizen(String name, int id) {
        super(name, id);
    }

    //----------------------------methods------------------------------//
    @Override
    public String action(Player target){
        return "";
    }
    //----------------------------methods------------------------------//
    //-----------------------------setter and getter----------------//
    @Override
    public String toString(){
        return name;
    }
    //-----------------------------setter and getter----------------//
}