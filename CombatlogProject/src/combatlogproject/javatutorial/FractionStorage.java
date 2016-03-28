package combatlogproject.javatutorial;

import java.util.*;

/**
 *
 * @author Domenik Irrgang
 */
public class FractionStorage {

    private List<Fraction> fractionList = new ArrayList<Fraction>();

    public FractionStorage() {
    }

    public void addFraction(Fraction fraction) {
        fractionList.add(fraction);
    }
    
    public void removeFraction(Fraction fraction) {
        fractionList.remove(fraction);
    }

    public void printStorage() {
        for (Fraction fraction : fractionList) {
            System.out.println(fraction);
        }       
    }

    public Fraction getFraction(int index) {
        return fractionList.get(index);
    }
    
    public static void main(String[] args) {
        FractionStorage storage = new FractionStorage();
        storage.addFraction(new Fraction(1,2));
        storage.addFraction(new Fraction(4,4));
        storage.removeFraction(new Fraction(4,4));
        storage.printStorage();
    }
}
