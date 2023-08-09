package ir.sharif.math.ap2023.mafia.model;

public class Detective extends Citizen {
    public Detective(String name, int id) {
        super(name, id);
    }
    //----------------------------methods------------------------------//
    @Override
    public String toString(){
        return name;
    }
    @Override
    public String action(Player target){
        if (target instanceof Mafia){
            if (target instanceof GodFather){
                if (((GodFather) target).asked){
                    return "MAFIA";
                }
                else {
                    ((GodFather) target).asked();
                    return "NO_MAFIA";
                }
            }
            else {
                return "MAFIA";
            }
        }
        else {
            return "NO_MAFIA";
        }
    }
    //----------------------------methods------------------------------//
    //-----------------------------setter and getter----------------//

    //-----------------------------setter and getter----------------//
}