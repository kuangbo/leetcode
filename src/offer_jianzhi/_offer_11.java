package offer_jianzhi;

public class _offer_11 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

    public int minArray(int[] numbers) {
        if (numbers.length == 1)
            return numbers[0];
        int left = 0;
        int right = numbers.length-1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right])
                left = mid + 1;
            else if (numbers[mid] < numbers[right])
                right = mid;
            else right --;
        }
        return numbers[left];
    }
}
