import java.util.Locale;

public class Main {

    private static final Employee[] EMPLOYEES = new Employee[10];

    public static void main(String[] args) {

        EMPLOYEES[0] = new Employee("Иванов Иван Иванович", 0, 50_000);
        EMPLOYEES[1] = new Employee("Иванов Петр Иванович", 1, 55_000);
        EMPLOYEES[2] = new Employee("Иванов Иван Петрович", 2, 57_000);
        EMPLOYEES[3] = new Employee("Петров Иван Иванович", 3, 40_000);
        EMPLOYEES[4] = new Employee("Петров Петр Иванович", 4, 53_000);
        EMPLOYEES[5] = new Employee("Иванов Петр Петрович", 5, 51_000);
        EMPLOYEES[6] = new Employee("Петров Петр Петрович", 6, 50_500);

        printFullInfo();
        int totalSalaries = getTotalSalaries();
        System.out.println("Сумма ЗП: " + totalSalaries);
        Employee employeeWithMinSalary = findEmployeeWithMinSalary();
        System.out.println("Сотрудник с минимальной ЗП: " + employeeWithMinSalary);
        Employee employeeWithMaxSalary = findEmployeeWithMaxSalary();
        System.out.println("Сотрудник с максимальной ЗП: " + employeeWithMaxSalary);
        double averageSalary = findAverageSalary();
        System.out.printf(Locale.US, "Средняя ЗП: %.2f%n", averageSalary);
        printFullNameInfo();
    }

    private static void printFullInfo() {

        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                System.out.println(employee);
            }

        }

    }

    private static int getTotalSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                sum = sum + employee.getSalary();
            }

        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary() {
        int min = Integer.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getSalary() < min) {
                min = employee.getSalary();
                employeeWithMinSalary = employee;
            }

        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalary() {
        int max = Integer.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employee != null && employee.getSalary() > max) {
                max = employee.getSalary();
                employeeWithMaxSalary = employee;
            }

        }
        return employeeWithMaxSalary;
    }


    private static double findAverageSalary() {
        int count = 0;
        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                count++;
            }
        }
        if (count != 0) {
            return (double) getTotalSalaries() / count;
        }
        return 0;
    }

    private static void printFullNameInfo() {

        for (Employee employee : EMPLOYEES) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }

        }
    }
}