package foo.zongzhe.data_structure.line.hash_table;

/**
 * 使用哈希表来管理雇员信息
 */
public class HashTableDemo {

    public static void main(String[] args) {
        EmployeeSystem empSys = new EmployeeSystem();

        empSys.add(new Employee(1,"Zongzhe"));
        empSys.add(new Employee(2,"Zongzhe2"));
        empSys.add(new Employee(16,"Zongzhe16"));
        empSys.add(new Employee(1,"ZongzheOther1"));

        empSys.printAllEmp();
    }
}
