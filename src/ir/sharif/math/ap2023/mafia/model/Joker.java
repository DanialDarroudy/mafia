package ir.sharif.math.ap2023.mafia.model;

public class Joker extends Player{

    public Joker(String name, int id){
        super(name, id);
    }
    //----------------------------methods------------------------------//

    public String action(Player target){
        return "";
    }
    @Override
    public String toString(){
        return name;
    }
    //----------------------------methods------------------------------//
    //-----------------------------setter and getter----------------//

    //-----------------------------setter and getter----------------//
}