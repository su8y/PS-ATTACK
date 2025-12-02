package solved.ac;

public class SortColorsClass {
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * [ 1, 0, 2, 2, 0, 1, 2, 1, 0 ] => [0,0,0,1,1,1,2,2,2]
     * 0p                      2p
     * i ==>
     */
    public static void SortColor(int[] nums) {
        int pointer_0 = 0, pointer_2 = nums.length - 1;
        int i = 0; // main logic
        while (i <= pointer_2) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums, pointer_0, i);
                i++; // 얘는 검증을 하면서 올라오기때문에 이친구 뒤에는 0 밖에 존재하수없다.
                pointer_0++;
            }
            /* 여기서 i++을 안해주는 이유는 간단하다. 생각을 해보자 pointer2 의 위치한 값은 0 이든 1든 2든 뭐든지 올수있다. 그렇기 때문에 한번더 검증할 필요가 있어 i ++ 을 해주지않는다. */
            else if (nums[i] == 2) {
                swap(nums, i, pointer_2);
                pointer_2--;
            }

        }


    }
}
