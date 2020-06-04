package foo.zongzhe.data_structure.line.hash_table;

import java.util.Hashtable;
import java.util.LinkedList;

public class EmployeeSystem {
    private Hashtable<Integer, LinkedList<Employee>> employeeTable;
    private final static int MOD = 20;

    public EmployeeSystem() {
        employeeTable = new Hashtable<>();
    }

    /**
     * 增加
     *
     * @param emp
     */
    public void add(Employee emp) {
        int hashKey = emp.getId() % MOD;
        if (!employeeTable.contains(hashKey)) {
            employeeTable.put(hashKey, new LinkedList<>());
            employeeTable.get(hashKey).add(emp);
        }
    }

    /**
     * 删除
     *
     * @param id
     */
    public void delete(int id) {
        int hashKey = id % MOD;
        if (!employeeTable.contains(hashKey)) {
            System.out.println("No such Employee with given ID");
            return;
        }
        LinkedList<Employee> empList = employeeTable.get(hashKey);
        empList.removeIf(employee -> employee.getId() == id);
    }

    /**
     * 查找某一位员工的具体信息
     *
     * @param id
     */
    public void getEmpInfo(int id) {
        int hashKey = id % MOD;
        if (!employeeTable.contains(hashKey)) {
            System.out.println("No such Employee with given ID");
            return;
        }
        LinkedList<Employee> empList = employeeTable.get(hashKey);
        Employee targetEmp = null;
        for (Employee employee : empList) {
            if (employee.getId() == id) {
                targetEmp = employee;
                break;
            }
        }

        if (targetEmp == null) {
            System.out.println("No such Employee with given ID");
        } else {
            System.out.println(targetEmp);
        }
    }

    /**
     * 打印所有Emp信息
     */
    public void printAllEmp() {
        System.out.println("printing all employees");
        for (LinkedList<Employee> empList : employeeTable.values()) {
            for (Employee employee : empList) {
                System.out.println(employee);
            }
        }
        System.out.println();
    }


}
