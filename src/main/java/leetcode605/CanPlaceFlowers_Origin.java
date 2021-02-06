package leetcode605;

/**
 * https://leetcode-cn.com/problems/can-place-flowers/
 * 思路：
 * 对于非边界情况：
 * 我只要找到连续3个0就表示中间那个0位必定可以种花，然后我只需要从中间这个位置开始再次寻找连续的3个0即可
 * 对于边界情况：
 * 边界情况001XXXX或是XXXXX100并没有出现连续的3个0但是也可以种，这里可以在数组前后各添加一个0来解决
 */
public class CanPlaceFlowers_Origin {

    public static void main(String[] args) {
        int[] flowerbed = new int[]{
                1, 0, 0, 0, 0, 0, 1
        };
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] newFlowerbed = new int[flowerbed.length + 2];
        newFlowerbed[0] = 0;
        System.arraycopy(flowerbed, 0, newFlowerbed, 1, flowerbed.length);
        newFlowerbed[newFlowerbed.length - 1] = 0;
        int flowerNum = 0;
        int repeatOfZero = 0;
        for (int i = 0; i < newFlowerbed.length; i++) {
            if (newFlowerbed[i] == 1) {
                repeatOfZero = 0;
            } else {
                repeatOfZero++;
            }
            if (repeatOfZero == 3) {
                flowerNum++;
                repeatOfZero = 0;
                i--;
                if (flowerNum >= n) {
                    return true;
                }
            }
        }
        return flowerNum >= n;
    }
}
