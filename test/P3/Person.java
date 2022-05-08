package P3;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private List<Person>friend;
    public Person(String name){
        this.name = name;
        friend = new ArrayList<>();
    }
    public void addfriend(Person p){
        friend.add(p);
    }
    public String getname(){
        return this.name;
    }
    public List<Person> getfriend(){
        return friend;
    }
}
