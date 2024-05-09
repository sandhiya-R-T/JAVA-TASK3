package oopsprogramming;

interface Taxable {
    double SALES_TAX_RATE = 0.07;
    double INCOME_TAX_RATE = 0.105;

    double calculateTax();
}

class Employee implements Taxable {
        private String name;
    private double salary;

       public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    
        public double calculateTax() {
        return salary * INCOME_TAX_RATE;
    }
}

class Product implements Taxable {
       private int pid;
    private double price;
    private int quantity;

       public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

        @Override
    public double calculateTax() {
        return price * SALES_TAX_RATE * quantity;
    }
}


public class DriverMain {
    public static void main(String[] args) {
                Employee employee = acceptEmployeeInfo();

                Product product = acceptProductInfo();

                double incomeTax = employee.calculateTax();
        System.out.println("Income Tax: $" + incomeTax);

                double salesTax = product.calculateTax();
        System.out.println("Sales Tax: $" + salesTax);
    }

       public static Employee acceptEmployeeInfo() {
                String name = "Kavin";
        double salary = 50000.0;
        return new Employee(name, salary);
    }

        public static Product acceptProductInfo() {
 
        int pid = 101;
        double price = 10.0;
        int quantity = 5;
        return new Product(pid, price, quantity);
    }
}
