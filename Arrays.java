import java.util.random.RandomGenerator;

public class Arrays {

    public static int[] generate(int start, int end, int sz) {
        RandomGenerator rnd = RandomGenerator.getDefault();
        int[] numbers = new int[sz];
        for (int i = 0; i < sz; ++i) {
            numbers[i] = rnd.nextInt(start, end);
        }
        return numbers;
    }

    public static void display(int[] numbers) {
        for (int i = 0; i < numbers.length; ++i) {
            if (i != 0 && i % 10 == 0)
                System.out.println();
            System.out.print(numbers[i] + "\t");
        }
    }

    // ✅ Add this main method
    public static void main(String[] args) {
        int[] nums = generate(1, 10, 30); // generate 30 random numbers between 1 and 100
        display(nums);
    }
}