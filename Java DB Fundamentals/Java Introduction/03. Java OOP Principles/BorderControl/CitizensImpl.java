package BorderControl;


public class CitizensImpl implements Citizens {

    private  String id;
    private int age;
    private String name;

    public CitizensImpl(String id, String name, int age) {
        this.setId(id);
        this.setAge(age);
        this.setName(name);
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
}
