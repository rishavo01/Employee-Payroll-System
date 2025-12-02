import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int ID;

    public Employee(String name , int ID){
        this.name = name;
        this.ID = ID;
    }

    public String getName(){
        return this.name;
    }
    public int getID(){
        return this.ID;
    }

    public abstract double calculateSalary();
    @Override

    public String toString(){
        return "Name: " + name + ",ID: " +ID + "salary: " + calculateSalary();
    }
}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name,int ID,double monthlySalary){
        super(name,ID);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}


class PartTimeEmployee extends Employee{
    private int hoursWorked;

    private double hourlyRate;

    public PartTimeEmployee(String name,int ID,int hoursWorked,double hourlyRate){
        super(name,ID);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    @Override
    public double calculateSalary(){
        return hourlyRate * hoursWorked;
    }
}

class payrollSystem {
    private ArrayList<Employee> employeeList;

    public payrollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
//    public void removeEmployee(Employee employee){
//        employeeList.remove(employee);
//    }
    public void removeEmployee(int ID){
        Employee removeEmployee = null;
        for(Employee employee: employeeList){
            if(employee.getID() == ID){
                removeEmployee=employee;
                break;
            }
        }
        if(removeEmployee != null){
            employeeList.remove(removeEmployee);
        }
    }
    public void displayEmployee(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}

class Main {
    public static void main(String[] args) {
        payrollSystem ps = new payrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Rishav",1,50000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Ram",2,40,100);

        ps.addEmployee(emp1);
        ps.addEmployee(emp2);
        ps.removeEmployee(2);
        ps.displayEmployee();
    }
}