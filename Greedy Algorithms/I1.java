import java.util.ArrayList;
import java.util.Collections;

public class I1 {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("Aman", 34));
        list.add(new Person("Akbar", 42));
        list.add(new Person("Anthony", 28));

        Collections.sort(list);
        System.out.println(list);
    }
}

class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /* 
     * This function compares two objects.
     * A person object is passed as an argument.
     * It returns a negative integer, zero, or a positive integer
     * if this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Person person) {
        if (this.age == person.age) {
            return this.name.compareTo(person.name);
        } else {
            return Integer.compare(this.age, person.age);
        }
    }

    @Override
    public String toString() {
        return this.name + ";" + this.age;
    }
}
