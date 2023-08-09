package ir.sharif.math.ap2023.mafia.model;

public class DoctorLecter extends Mafia {

    public DoctorLecter(String name, int id) {
        super(name, id);
    }

    //----------------------------methods------------------------------//
    @Override
    public String action(Player target) {
            target.healedWithDocLec = true;
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