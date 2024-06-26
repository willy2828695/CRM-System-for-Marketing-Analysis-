
package model.Personnel;

import java.util.ArrayList;


public class PersonDirectory {

    ArrayList<Person> personList;

    public PersonDirectory() {

        personList = new ArrayList<Person>();

    }

    public Person newPerson(String id) {

        Person p = new Person(id);
        personList.add(p);
        return p;
    }

    public Person findPerson(String id) {

        for (Person p : personList) {

            if (p.isMatch(id)) {
                return p;
            }
        }
        return null; // not found after going through the whole list
    }

}
