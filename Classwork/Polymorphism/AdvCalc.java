public class AdvCalc extends Calculator {

    // Overridden method of base class and then implemented  to subtract two integers
    @Override
    public int operation(int a, int b) {
        return a - b;
    }

    // Overloaded method to add three integers (overrides multiplication in Calculator)
    @Override
    public int operation(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two doubles (overrides division in Calculator)
    @Override
    public double operation(double a, double b) {
        return a + b;
    }
}
