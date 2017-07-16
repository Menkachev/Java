package BorderControl;


public class CitizensImpl implements Citizens {

    private  String id;
    private int age;
    private String name;
    private String birthday;


    public CitizensImpl(String id, String name, int age, String birthday) {
        this.setId(id);
        this.setAge(age);
        this.setName(name);
        this.setBirthday(birthday);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
