class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "ID: " + employeeId + " | Name: " + name + " | Position: " + position + " | Salary: $" + salary;
    }
}

public class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (size >= employees.length) {
            System.out.println("Error: System at max capacity. Cannot add " + emp.getName());
            return false;
        }
        employees[size] = emp;
        size++;
        return true;
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No records found.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployee(String employeeId) {
        int targetIndex = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equalsIgnoreCase(employeeId)) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            return false;
        }

        for (int i = targetIndex; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[size - 1] = null;
        size--;
        return true;
    }

    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager(5);

        em.addEmployee(new Employee("E001", "Alice Smith", "Manager", 85000));
        em.addEmployee(new Employee("E002", "Bob Jones", "Developer", 70000));
        em.addEmployee(new Employee("E003", "Charlie Brown", "Designer", 65000));

        System.out.println("--- Current Employee Records ---");
        em.traverseEmployees();

        System.out.println("\n--- Searching for E002 ---");
        Employee found = em.searchEmployee("E002");
        System.out.println(found != null ? found : "Employee not found.");

        System.out.println("\n--- Deleting E002 ---");
        if (em.deleteEmployee("E002")) {
            System.out.println("Successfully deleted E002.");
        }

        System.out.println("\n--- Final Employee Records ---");
        em.traverseEmployees();
    }
}