import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Worker {
    private String name;
    private int age;
    private BigDecimal salary;
    private LocalDate hireDate;

    public Worker() {
    }

    public Worker(String name, int age, BigDecimal salary, LocalDate hireDate) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isBetweenAge(int age1, int age2) {
        return age >= age1 && age <= age2;
    }

    public boolean hasNameStartingWith(String pattern)
    {
        return name.startsWith(pattern);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        Worker worker = (Worker) o;
        return getAge() == worker.getAge() &&
                Objects.equals(getName(), worker.getName()) &&
                Objects.equals(getSalary(), worker.getSalary()) &&
                Objects.equals(getHireDate(), worker.getHireDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getSalary(), getHireDate());
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}
