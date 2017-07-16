package BorderControl;


public class PetsImpl implements Pets {

    private String birthday;
    private String name;

    public PetsImpl(String birthday, String name) {
        this.setBirthday(birthday);
        this.setName(name);
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
