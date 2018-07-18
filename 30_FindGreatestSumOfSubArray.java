//动态规划
//01
import java.util.*;
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int g = 0x80000000;//假定为最小负数
        int l = 0;
        for(int a : array){  //i从0开始，因为l初始化为0         
            l = Math.max(a, l+a);
            g = Math.max(l, g);
        }
        return g;
    }
}
//02
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int g = array[0];//这里用数组元素初始化
        int l = array[0];
        for (int i = 1; i < array.length; i++) {//i从1开始
            l = (l > 0) ? l+array[i] : array[i];
            g = (l > g) ? l : g;
        }
        return g;
    }
}
//03
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
         if (array.length==0 || array==null) {
             return 0;
         }
        int greatestSum = 0x80000000;
        int curSum = 0;
        for(int i=0; i<array.length; i++){           
            if(curSum<0){
                curSum = array[i];
            }
            else{
                curSum += array[i];
            }
            if(curSum > greatestSum)
                greatestSum = curSum;
        }
        return greatestSum;
    }
}
