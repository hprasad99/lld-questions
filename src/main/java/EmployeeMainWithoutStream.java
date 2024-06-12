import entities.Employee;

import java.util.*;

public class EmployeeMainWithoutStream {

    public static void main(String[] args) {
        HashMap<Integer, Employee> map = new LinkedHashMap<>();

        List<Employee> employeeList = Arrays.asList(
                new Employee(3, "John"),
                new Employee(1, "Alice"),
                new Employee(2, "Bob")
        );
        employeeList.sort(Comparator.comparing(Employee::getId));

        for(Employee employee: employeeList) {
            map.put(employee.getId(), employee);
        }

        System.out.println(map);
    }
}
