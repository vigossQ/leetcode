import com.vigoss.util.CodeUtil;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int size = 7;
        int range = 10;
//        int[] ints = CodeUtil.generateRandomIntArr(size, range);
//        int[] ints = new int[]{3, 1, 1, 0, 1, 2, 7};
        int[] ints = new int[]{5, 9, 0, 5, 3, 8, 4};
        System.out.println(Arrays.toString(ints));
        CodeUtil.heapSort(ints);
        System.out.println(Arrays.toString(ints));

    }
}
