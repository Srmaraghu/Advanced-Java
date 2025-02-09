public class Main{
    public static void main(String[] args){
        Calculator c = new Calculator();
        System.out.println("Sum operation: "+c.operation(3,4));
        System.out.println("Product operation: "+c.operation(2,4,3));
        System.out.println("Division operation: "+c.operation(12.33,4.3));


        AdvCalc a = new AdvCalc();
        System.out.println("\nDifference operation: "+a.operation(3,4));
        System.out.println("Three digits sum: "+a.operation(2,4,3));
        System.out.println("Double datatype  sum: "+a.operation(12.33,4.3));

    }
}