public class SalariedEmployee extends Employee {
    private int salary;

    SalariedEmployee(){

    }

    public void setSalary(int salary) {
        if (salary<0){
            this.salary=0;
        }
        else{
            this.salary = salary;
        }
    }

    public float earning(){
        return salary;
    };

    public String toString(){
        return salary+"";
    };
}

