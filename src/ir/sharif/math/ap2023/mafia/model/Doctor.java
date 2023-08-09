package ir.sharif.math.ap2023.mafia.model;

public class Doctor extends Citizen {
    public int numberOfSelfSave = 2;

    public Doctor(String name, int id) {
        super(name, id);
    }
    //----------------------------methods------------------------------//
    @Override
    public String toString(){
        return name;
    }
    @Override
    public String action(Player target) {
        if (target == this) {
            if (this.numberOfSelfSave > 0) {
                target.healedWithDoc = true;
                this.numberOfSelfSave--;
                return "";
            } else {
                return "NO_SAVE";
            }
        } else {
            target.healedWithDoc = true;
            return "";
        }
    }
    //----------------------------methods------------------------------//
    //-----------------------------setter and getter----------------//

    public int getNumberOfSelfSave() {
        return numberOfSelfSave;
    }

    public void setNumberOfSelfSave(int numberOfSelfSave) {
        this.numberOfSelfSave = numberOfSelfSave;
    }
    //-----------------------------setter and getter----------------//
}