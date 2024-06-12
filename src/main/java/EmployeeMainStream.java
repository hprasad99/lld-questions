import entities.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeMainStream {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Alice"),
                new Employee(2, "Bob")
        );

        Map<Integer, Employee> map = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getId))
                .collect(Collectors.toMap(
                        Employee::getId,
                        employee -> employee,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        System.out.println(map);


    }
}
