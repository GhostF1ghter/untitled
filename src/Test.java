import java.util.Comparator;
import java.util.TreeSet;
import java.util.regex.Pattern;

class Test{
//    public static void main(String[] args) {
//        Comparator<Person> pcomp = new PersonNameComparator().thenComparing(new PersonAgeComparator());
//        TreeSet<Person> people = new TreeSet(pcomp);
//        people.add(new Person("Tom", 23));
//        people.add(new Person("Nick",34));
//        people.add(new Person("Tom",10));
//        people.add(new Person("Bill",14));
//
//        for(Person  p : people){
//
//            System.out.println(p.getName() + " " + p.getAge());
//        }
//    }

    public static void main(String[] args) {

        String input = "Hello Java! Hello JavaScript! JavaSE 8.";
        Pattern pattern = Pattern.compile("[ ,.!?]");
        String[] words = pattern.split(input);
        for(String word:words)
            System.out.println(word);
    }

}
class Person{

    private String name;
    private int age;
    public Person(String n, int a){
        name=n;
        age=a;
    }
    String getName(){return name;}
    int getAge(){return age;}
}
class PersonNameComparator implements Comparator<Person>{

    public int compare(Person a, Person b){

        return a.getName().compareTo(b.getName());
    }
}
class PersonAgeComparator implements Comparator<Person>{

    public int compare(Person a, Person b){

        if(a.getAge()> b.getAge())
            return 1;
        else if(a.getAge()< b.getAge())
            return -1;
        else
            return 0;
    }
}
