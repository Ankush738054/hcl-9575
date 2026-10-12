import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public class Task1 {

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        // Create
        addEmployee(employees, new Employee(103, "Maya", 62000));
        addEmployee(employees, new Employee(101, "Arun", 55000));
        addEmployee(employees, new Employee(102, "Sara", 59000));

        // Read with Iterator and ListIterator
        System.out.println("Employees using Iterator:");
        displayUsingIterator(employees);

        System.out.println("\nEmployees using ListIterator (forward):");
        displayUsingListIterator(employees);

        // Update
        updateEmployee(employees, 102, "Sara", 64000);
        System.out.println("\nAfter updating employee 102:");
        displayUsingIterator(employees);

        // Delete
        deleteEmployee(employees, 101);
        System.out.println("\nAfter deleting employee 101:");
        displayUsingIterator(employees);

        // Display in increasing and decreasing order of employee ID
        System.out.println("\nEmployees in increasing ID order:");
        displayInOrder(employees, false);

        System.out.println("\nEmployees in decreasing ID order:");
        displayInOrder(employees, true);

        System.out.println("\nEmployees using ListIterator (backward):");
        displayBackwardUsingListIterator(employees);
    }

    private static void addEmployee(ArrayList<Employee> employees, Employee employee) {
        employees.add(employee);
    }

    private static void displayUsingIterator(ArrayList<Employee> employees) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void displayUsingListIterator(ArrayList<Employee> employees) {
        ListIterator<Employee> iterator = employees.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void displayBackwardUsingListIterator(ArrayList<Employee> employees) {
        ListIterator<Employee> iterator = employees.listIterator(employees.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    private static boolean updateEmployee(
            ArrayList<Employee> employees, int employeeId, String name, double salary) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employee.setName(name);
                employee.setSalary(salary);
                return true;
            }
        }
        return false;
    }

    private static boolean deleteEmployee(ArrayList<Employee> employees, int employeeId) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == employeeId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    private static void displayInOrder(ArrayList<Employee> employees, boolean descending) {
        ArrayList<Employee> sortedEmployees = new ArrayList<>(employees);
        Comparator<Employee> byId = Comparator.comparingInt(Employee::getId);
        if (descending) {
            byId = byId.reversed();
        }
        sortedEmployees.sort(byId);
        displayUsingIterator(sortedEmployees);
    }

    private static class Employee {
        private final int id;
        private String name;
        private double salary;

        private Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        private int getId() {
            return id;
        }

        private void setName(String name) {
            this.name = name;
        }

        private void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
        }
    }
}
