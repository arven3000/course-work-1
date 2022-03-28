package pro.sky.java.course1;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class EmployeeBook {

    private final ArrayList<Employee> employees;

    public EmployeeBook() {
        this.employees = new ArrayList<>();
    }

    private ArrayList<Employee> filterByDepartment(ArrayList<Employee> employees, int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department).collect(Collectors.toCollection(ArrayList::new));
    }

    public double sumAmount() {
        return sumAmount(employees);
    }

    /*Посчитать сумму затрат на зарплаты по отделу*/
    public double sumAmount(int department) {
        ArrayList<Employee> employeesByDepartment = filterByDepartment(employees, department);
        return sumAmount(employeesByDepartment);
    }

    /*Посчитать сумму затрат на зарплаты*/
    private double sumAmount(ArrayList<Employee> employees) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            sum += employee.getSalary();
        }
        return sum;
    }

    public double minSalary() {
        return minSalary(employees);
    }

    /*Найти сотрудника с минимальной зарплатой по отделу*/
    public double minSalary(int department) {
        ArrayList<Employee> employeesByDepartment = filterByDepartment(employees, department);
        return minSalary(employeesByDepartment);
    }

    /*Найти сотрудника с минимальной зарплатой*/
    private double minSalary(ArrayList<Employee> employees) {
        double min = 0;
        if (employees.size() != 0) {
            min = employees.get(0).getSalary();
            for (Employee employee : employees) {
                if (min > employee.getSalary()) {
                    min = employee.getSalary();
                }
            }
        }
        return min;
    }

    public double maxSalary() {
        return maxSalary(employees);
    }

    /*Найти сотрудника с максимальной заплатой по отделу*/
    public double maxSalary(int department) {
        ArrayList<Employee> employeesByDepartment = filterByDepartment(employees, department);
        return maxSalary(employeesByDepartment);
    }

    /*Найти сотрудника с максимальной зарплатой*/
    private double maxSalary(ArrayList<Employee> employees) {
        double max = 0;
        if (employees.size() != 0) {
            max = employees.get(0).getSalary();
            for (Employee employee : employees) {
                if (max < employee.getSalary()) {
                    max = employee.getSalary();
                }
            }
        }
        return max;
    }

    public double averageSalary() {
        return averageSalary(employees, employees.size());
    }

    /*Подсчитать среднее значение зарплат по отделу*/
    public double averageSalary(int department) {
        ArrayList<Employee> employeesByDepartment = filterByDepartment(employees, department);
        return averageSalary(employeesByDepartment, employeesByDepartment.size());
    }


    /*Подсчитать среднее значение зарплат*/
    private double averageSalary(ArrayList<Employee> employees, int len) {
        if (employees.size() != 0) {
            return sumAmount(employees) / len;
        }
        return 0.0;
    }

    /*Прибавить процент к зарплате*/
    public void salaryIncrease(int percent) {
        salaryIncrease(employees, percent);
    }

    /*Прибавить процент к зарплате по отделу*/
    public void salaryIncrease(int department, int percent) {
        ArrayList<Employee> employeesByDepartment = filterByDepartment(employees, department);
        salaryIncrease(employeesByDepartment, percent);
    }

    private void salaryIncrease(ArrayList<Employee> employees, int percent) {
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary() + employee.getSalary() * percent / 100);
        }
    }

    /*Отфильтровать по максимуму зарплате*/
    public void maxFilterSalary(int number) {
        for (Employee employee : employees) {
            if (employee.getSalary() > number) {
                System.out.println(employee.getId() + ": " +
                        employee.getName() + " " +
                        employee.getSalary());
            }
        }
    }

    /*Отфильтровать по миниму зарплате*/
    public void minFilterSalary(int number) {
        for (Employee employee : employees) {
            if (employee.getSalary() < number) {
                System.out.println(employee.getId() + ": " +
                        employee.getName() + " " +
                        employee.getSalary());
            }
        }
    }

    /*Добавить сотрудника*/
    public void add(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    /*Удалить сотрудника по имени*/
    public boolean delete(String employeeName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equals(employeeName)) {
                employees.remove(employees.get(i));
                return true;
            }
        }
        return false;
    }

    /*Удалить сотрудника по id*/
    public boolean delete(int id) {
        if (id < employees.size() && id > 0) {
            employees.remove(employees.get(id - 1));
            return true;
        }
        return false;
    }

    /*Изменить отдел сотрудника */
    public Employee updateEmployeeDepartment(String name, int department) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employee.setDepartment(department);
                return employee;
            }
        }
        return null;
    }

    /*Изменить зарплату сотрудника*/
    public Employee updateEmployeeSalary(String name, double salary) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employee.setSalary(salary);
                return employee;
            }
        }
        return null;
    }

    /*Получить всех сотрудников*/
    public void employeesInfo() {
        System.out.println("Список сотрудников: ");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /*Получить Ф. И. О. всех сотрудников по отделам (все данные, кроме отдела)*/
    public void employeesInfoByDepartment(int department) {
        for (Employee employee : employees) {
            if (employee.getDepartment() == department) {
                System.out.println(employee.getId() + ": " + employee.getName()
                        + " " + employee.getSalary());
            }
        }
    }

    /*Получить Ф. И. О. всех сотрудников*/
    public void employeeNameInfo() {
        System.out.println("Поименный список сотрудников: ");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    /*Получить Ф. И. О. всех сотрудников по отделам(список отделов и их сотрудников)*/
    public void departmentInfo() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + ": ");
            for (Employee employee : employees) {
                if (employee.getDepartment() == i) {
                    System.out.println(employee.getName());
                }
            }
        }
    }
}
