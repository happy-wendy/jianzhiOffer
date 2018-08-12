//题目：从扑克牌中随机抽5张牌，判断是不是一个顺子， 即这5张牌是不是连续的。2～10为数字本身， A为1。 J为11、Q为12、 为13。小王可以看成任意数字。
//思路：判断输入；sort;统计0的个数；出现重复就return false没有就统计gap数；
import java.util.Arrays;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        int numOfZero = 0, numOfGap = 0;
        for (int i = 0; i <numbers.length && numbers[i] == 0; i++) {
            numOfZero++;
        }
        //该题中是有四个王
        if (numOfZero > 4) {
            return false;
        }
        int small = numOfZero, big = small + 1;
        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }
            numOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        return numOfGap <= numOfZero;
    }
}
//02用bit做标记，节省空间
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length != 5) return false;
        int min = 14;
        int max = -1;
        int flag = 0;//无序也可以用flag：了解下bitmap排序
        for(int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if(number < 0 || number > 13) return false;
            if(number == 0) continue;
            if(((flag >> number) & 1) == 1) return false;//用二进制位来判断是否有数字重复
            flag |= (1 << number);
            if(number > max) max = number;
            if(number < min) min = number;
            if(max - min >= 5) return false;
        }
        return true;//1、max - min < 5，即最大差值是4，确保数组元素值不会太分散2、除0外没有重复的数，确保数组元素值不会太密集(重复)。
    }
}
