
public class Relation implements Comparable<Relation>{
    private int person, targetPerson, minutes;

    public Relation(int person, int targetPerson, int minutes){
        this.person = person;
        this.targetPerson = targetPerson;
        this.minutes = minutes;
    }

    @Override
    public int compareTo(Relation relation){
        return minutes - relation.getMinutes();
    }

    @Override
    public String toString(){
        return String.valueOf(minutes);
    }

    public int getMinutes(){
        return this.minutes;
    }

    public int getPerson(){
        return person;
    }
    
    public int getTarget(){
        return targetPerson;
    }

}