package ir.sharif.math.ap2023.mafia.model;

public class Sniper extends Citizen {
    public int numberOfBulletsLeft = 2;
    public Sniper(String name, int id) {
        super(name, id);
    }

    //----------------------------methods------------------------------//
    @Override
    public String action(Player target){
        if (this.numberOfBulletsLeft > 0){
            target.killedWithSniper = true;
            this.numberOfBulletsLeft--;
            return "";
        }
        else {
            return "NO_BULLETS";
        }
    }
    @Override
    public String toString(){
        return name;
    }
    //----------------------------methods------------------------------//
    //-----------------------------setter and getter----------------//

    public int getNumberOfBulletsLeft() {
        return numberOfBulletsLeft;
    }

    public void setNumberOfBulletsLeft(int numberOfBulletsLeft) {
        this.numberOfBulletsLeft = numberOfBulletsLeft;
    }

    //-----------------------------setter and getter----------------//

}