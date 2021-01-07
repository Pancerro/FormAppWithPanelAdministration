package pl.pancerro.backend.model;

public class Charts {

    String name;
    long value;

    public Charts(String name, long value) {
        this.name = name;
        this.value = value;
    }

    public Charts() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Charts{" +
                "nameCourses='" + name + '\'' +
                ", countCourses=" + value +
                '}';
    }
}
