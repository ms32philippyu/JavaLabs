import java.util.Arrays;

public class Runner {
    private static int [] arr = {1,2,3,4,5,6,7,8};

    public static void main(String[] args) {
        getSumNeighbors(arr);
    }
    private static void getSumNeighbors(int [] nums) {
        int [] tmp;
        if (nums.length == 2) {
            System.out.println("Промежуточные значения сумм: " + Arrays.toString(nums));
            System.out.println("Окончательная сумма = " + (nums[0] + nums[1]));
            return;
        }
        System.out.println("Промежуточные значения сумм: " + Arrays.toString(nums));
        int highLimitIndexTmp;
        if (nums.length%2 == 0) {
            tmp = new int[nums.length/2];
            highLimitIndexTmp = tmp.length;
        }
        else {
            tmp = new int[nums.length/2 + 1];
            highLimitIndexTmp = tmp.length - 1;
            tmp[highLimitIndexTmp] = nums[nums.length - 1];
        }

        int j = 0;
        for (int i = 0; i < highLimitIndexTmp; i++) {
            tmp[i] = nums[j] + nums[j + 1];
            j+=2;
        }

        getSumNeighbors(tmp);
    }
}
