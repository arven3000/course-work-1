package pro.sky.java.course1;

public class Main {

    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();

        Employee employee1 = new Employee("Иванов Василий Петрович", 1, 2100);
        Employee employee2 = new Employee("Петров Иван Васильевич", 2, 2200);
        Employee employee3 = new Employee("Васильев Петр Иванович", 3, 2300);
        Employee employee4 = new Employee("Сидорова Ольга Олеговна", 4, 2400);
        Employee employee5 = new Employee("Григорьев Андрей Андреевич", 5, 2500);
        Employee employee6 = new Employee("Пономарёва Анна Александровна", 1, 2200);
        Employee employee7 = new Employee("Логинова Мария Анатольевна", 2, 2100);
        Employee employee8 = new Employee("Мухина Светлана Артемовна", 3, 2000);
        Employee employee9 = new Employee("Кравцов Алексей Евгеньевич", 4, 1700);
        Employee employee10 = new Employee("Варёнова Татьяна Владимировна", 5, 2800);

        employeeBook.add(employee1);
        employeeBook.add(employee2);
        employeeBook.add(employee3);
        employeeBook.add(employee4);
        employeeBook.add(employee5);
        employeeBook.add(employee6);
        employeeBook.add(employee7);
        employeeBook.add(employee8);
        employeeBook.add(employee9);
        employeeBook.add(employee10);

        employeeBook.employeeNameInfo();
        System.out.println();

        System.out.println("Информация о работниках по отделам:");
        employeeBook.employeesInfoByDepartment(2);
        employeeBook.employeesInfoByDepartment(5);
        System.out.println();


        System.out.println("Сумма затрат: " + employeeBook.sumAmount());
        System.out.println("Сумма затрат отдела 1: " + employeeBook.sumAmount(1));
        System.out.println("Сумма затрат отдела 2: " + employeeBook.sumAmount(2));
        System.out.println("Сумма затрат отдела 3: " + employeeBook.sumAmount(3));
        System.out.println("Сумма затрат отдела 4: " + employeeBook.sumAmount(4));
        System.out.println("Сумма затрат отдела 5: " + employeeBook.sumAmount(5));
        System.out.println();

        System.out.println("Минимальная зарплата : " + employeeBook.minSalary());
        System.out.println("Минимальная зарплата отдела 1: " + employeeBook.minSalary(1));
        System.out.println("Минимальная зарплата отдела 2: " + employeeBook.minSalary(2));
        System.out.println("Минимальная зарплата отдела 3: " + employeeBook.minSalary(3));
        System.out.println("Минимальная зарплата отдела 4: " + employeeBook.minSalary(4));
        System.out.println("Минимальная зарплата отдела 5: " + employeeBook.minSalary(5));
        System.out.println();

        System.out.println("Максимальная зарплата:" + employeeBook.maxSalary());
        System.out.println("Максимальная зарплата отдела 1:" + employeeBook.maxSalary(1));
        System.out.println("Максимальная зарплата отдела 2:" + employeeBook.maxSalary(2));
        System.out.println("Максимальная зарплата отдела 3:" + employeeBook.maxSalary(3));
        System.out.println("Максимальная зарплата отдела 4:" + employeeBook.maxSalary(4));
        System.out.println("Максимальная зарплата отдела 5:" + employeeBook.maxSalary(5));
        System.out.println();

        System.out.println("Средняя зарплата: " + employeeBook.averageSalary());
        System.out.println("Средняя зарплата отдела 1: " + employeeBook.averageSalary(1));
        System.out.println("Средняя зарплата отдела 2: " + employeeBook.averageSalary(2));
        System.out.println("Средняя зарплата отдела 3: " + employeeBook.averageSalary(3));
        System.out.println("Средняя зарплата отдела 4: " + employeeBook.averageSalary(4));
        System.out.println("Средняя зарплата отдела 5: " + employeeBook.averageSalary(5));
        System.out.println();

        System.out.print("Увеличение зарплаты ");
        employeeBook.salaryIncrease(20);
        employeeBook.employeesInfo();
        System.out.println();

        System.out.print("Увеличение зарплаты по отделам ");
        employeeBook.salaryIncrease(1, 10);
        employeeBook.salaryIncrease(2, 21);
        employeeBook.salaryIncrease(3, 13);
        employeeBook.salaryIncrease(4, 17);
        employeeBook.salaryIncrease(5, 25);
        employeeBook.employeesInfo();
        System.out.println();

        System.out.println("Сотрудники с зарплатой более 2800: ");
        employeeBook.maxFilterSalary(2800);
        System.out.println();
        System.out.println("Сотрудники с зарплатой менее 2500: ");
        employeeBook.minFilterSalary(2500);
        System.out.println();

        System.out.println("Удаление по id: ");
        System.out.println(employeeBook.delete(10));
        employeeBook.employeesInfo();
        System.out.println();

        System.out.println("Удаление по ФИО: ");
        System.out.println(employeeBook.delete("Пономарёва Анна Александровна"));
        employeeBook.employeesInfo();
        System.out.println();

        System.out.println("Добавление сотрудников");
        employeeBook.add(employee3);
        employeeBook.add(employee6);
        System.out.println();

        System.out.print("Изменение отдела: ");
        System.out.println(employeeBook.updateEmployeeDepartment("Кравцов Алексей Евгеньевич", 2));
        System.out.println();
        System.out.print("Изменение зарплаты: ");
        System.out.println(employeeBook.updateEmployeeSalary("Кравцов Алексей Евгеньевич", 2050));
        System.out.println();

        employeeBook.departmentInfo();
    }
}
