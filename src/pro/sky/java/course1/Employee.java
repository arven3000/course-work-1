package pro.sky.java.course1;

public class Employee {

    static int counter = 1;
    private final String name;
    private final int id;
    private int department;
    private double salary;

    public Employee(String name, int department, int salary) {
        this.id = counter++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Департамент задан не верно");
        }
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + ": " + name + " Отдел: " + department +
                " Зарплата: " + salary;
    }
}
