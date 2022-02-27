package pro.sky.java.course1;

public class EmployeeBook {

    private final Employee[] employees;

    public EmployeeBook(int size) {
        this.employees = new Employee[size];
    }

    /*Посчитать сумму затрат на зарплаты*/
    public double sumAmount() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            sum += employee.getSalary();
        }
        return sum;
    }

    /*Посчитать сумму затрат на зарплаты по отделу*/
    public double sumAmount(int department) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            sum += employee.getSalary();
        }
        return sum;
    }

    /*Найти сотрудника с минимальной заплатой*/
    public double minSalary() {
        double min = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (min > employee.getSalary()) {
                min = employee.getSalary();
            }
        }
        return min;
    }

    /*Найти сотрудника с минимальной заплатой по отделу*/
    public double minSalary(int department) {
        double min = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (min > employee.getSalary() && department == employee.getDepartment()) {
                min = employee.getSalary();
            }
        }
        return min;
    }

    /*Найти сотрудника с максимальной заплатой*/
    public double maxSalary() {
        double max = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (max < employee.getSalary()) {
                max = employee.getSalary();
            }
        }
        return max;
    }

    /*Найти сотрудника с максимальной заплатой по отделу*/
    public double maxSalary(int department) {
        double max = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (max < employee.getSalary() && department == employee.getDepartment()) {
                max = employee.getSalary();
            }
        }
        return max;
    }

    /*Подсчитать среднее значение зарплат*/
    public double averageSalary() {
        return sumAmount() / employees.length;
    }

    /*Подсчитать среднее значение зарплат по отделу*/
    public double averageSalary(int department) {
        int count = 0;
        double sum = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == department) {
                sum += employee.getSalary();
                count++;
            }
        }
        return sum / count;
    }

    /*Прибавить процент к зарплате*/
    public void salaryIncrease(int percent) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            employee.setSalary(employee.getSalary() + employee.getSalary() * percent / 100);
        }
    }

    /*Прибавить процент к зарплате по отделу*/
    public void salaryIncrease(int department, int percent) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
            if (employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * percent / 100);
            }
        }
    }

    /*Отфильтровать по максимуму зарплате*/
    public void maxFilterSalary(int number) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
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
            if (employee == null) {
                continue;
            }
            if (employee.getSalary() < number) {
                System.out.println(employee.getId() + ": " +
                        employee.getName() + " " +
                        employee.getSalary());
            }
        }
    }

    /*Добавить сотрудника*/
    public boolean add(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    /*Удалить сотрудника по имени*/
    public boolean delete(String employeeName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getName().equals(employeeName)) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    /*Удалить сотрудника по id*/
    public boolean delete(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getId() == id) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    /*Изменить отдел сотрудника */
    public Employee updateEmployeeDepartment(String name, int department) {
        for (Employee employee : employees) {
            if (employee == null) {
                continue;
            }
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
            if (employee == null) {
                continue;
            }
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
            if (employee == null) {
                continue;
            }
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
            if (employee == null) {
                continue;
            }
            System.out.println(employee.getName());
        }
    }

    /*Получить Ф. И. О. всех сотрудников по отделам(список отделов и их сотрудников)*/
    public void departmentInfo() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + ": ");
            for (Employee employee : employees) {
                if (employee == null) {
                    continue;
                }
                if (employee.getDepartment() == i) {
                    System.out.println(employee.getName());
                }
            }
        }
    }
}
