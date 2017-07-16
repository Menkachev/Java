package DefineAnInterfacePerson;

import java.util.Date;

/**
 * Created by Ivan on 6.7.2017 г..
 */
public class Citizen implements Person, Identifiable, Birthable {

    private String name;
    private int age;
    private String birthdate;
    private String id;

    public Citizen(String name, int age, String birthdate, String id) {
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getBirthdate() {
        return birthdate;
    }

    @Override
    public String getId() {
        return id;
    }
}
