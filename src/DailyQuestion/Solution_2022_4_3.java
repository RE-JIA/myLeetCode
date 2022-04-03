package DailyQuestion;

public class Solution_2022_4_3 {
    /*
        744. 寻找比目标字母大的最小字母
     */
    /*
        由于字符数组是有序的，因此可以使用二分查找的思想解决该问题。
     */
    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if(letters[n - 1] <= target) return letters[0];
        int left = 0, right = n - 1;
        int mid;
        while (left < right){
            mid = (left + right) / 2;
            if(letters[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if(letters[left] > target) return letters[left];
        return letters[left + 1];
    }

    public static void main(String[] args) {
        char[] letters = {'e','e','e','e','e','e','n','n','n','n'};
        System.out.print(nextGreatestLetter(letters,'e'));
    }
}
