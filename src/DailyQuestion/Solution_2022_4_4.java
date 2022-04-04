package DailyQuestion;

public class Solution_2022_4_4 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        NumArray numArray = new NumArray(a);

    }
}
/*
    307. 区域和检索 - 数组可修改
    
 */
class NumArray {
    private int[] num;//原数组
    private int size;//块大小
    private int[] sum;//数组块之和
    public NumArray(int[] nums) {
        num = nums;
        int n = nums.length;
        size = (int)Math.sqrt(n);
        if(n % size == 0) sum = new int[n/size];
        else sum = new int[n/size + 1];
        for (int i = 0; i < n; i++) {
            sum[i/size] += nums[i];
        }
    }

    public void update(int index, int val) {
        sum[index/size] += (val - num[index]);
        num[index] = val;
    }

    public int sumRange(int left, int right) {
        int l1 = left / size;
        int r1 = right / size;
        if(l1 == r1){
            int ans = 0;
            for(int i = left; i <= right; i++){
                ans += num[i];
            }
            return ans;
        }
        int sum1 = 0;
        for(int i = l1 + 1; i <= r1 - 1; i++){
            sum1 += sum[i];
        }
        int l2 = left % size;
        int r2 = right % size;
        int sum2 = 0;
        int sum3 = 0;
        if(l2 == 0){
            sum2 = sum[l1];
        }else {
            for(int i = left; i < size * (l1+1); i++){
                sum2 += num[i];
            }
        }

        if(r2 == size - 1){
            sum3 = sum[r1];
        }else {
            for(int i = size * r1; i <= right; i++){
                sum3 += num[i];
            }
        }
        return sum1 + sum2 + sum3;
    }
}
