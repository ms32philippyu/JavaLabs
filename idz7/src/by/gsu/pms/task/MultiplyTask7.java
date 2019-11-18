package by.gsu.pms.task;

public class MultiplyTask7 implements Task {

    private int max;

    public MultiplyTask7(int max) {
        this.max = max;
    }

    @Override
    public double calculate() {
        double result = 1;
        for (int i = 4; i <= max; i += 4) {
            result *= i;
        }
        return result;
    }
}
