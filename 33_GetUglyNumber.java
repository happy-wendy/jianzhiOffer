//列出所有丑数
//01
import java.util.ArrayList;
import java.lang.Math;
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index < 7) return index;
        ArrayList<Integer> list = new ArrayList<Integer>();//用ArrayList
        list.add(1);
        int t2 = 0, t3 = 0, t5 = 0;
        while(list.size() < index){
            int m2 = list.get(t2)*2;
            int m3 = list.get(t3)*3;
            int m5 = list.get(t5)*5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if(min == m2) t2++;
            if(min == m3) t3++;
            if(min == m5) t5++;
        }
        return list.get(list.size()-1);
    }
}
//02
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index<=0) return 0;
        int[] res = new int[index];//用数组
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, i;
        for (i = 1; i < index; ++i){
            res[i] = min(res[t2]*2, min(res[t3]*3, res[t5]*5));
            if (res[i] == res[t2]*2) t2++;
            if (res[i] == res[t3]*3) t3++;
            if (res[i] == res[t5]*5) t5++;
        }
        return res[index - 1];
    }
    private int min(int a, int b){
        return (a < b) ? a : b;
    }
}
//最易想到的解法：算法复杂度过大
public class Solution {
    public static void main(String[] args){
        int index = 150;
        Solution test = new Solution();
        System.out.println(test.GetUglyNumber_Solution(index));
    }
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        int num = 0;
        int uglyFound = 0;
        while(uglyFound < index){
            num++;
            if(isUgly(num)){
                ++uglyFound;
            }
        }
        return num;
    }
    public boolean isUgly(int number){
        while(number % 2 == 0)
            number/=2;
        while(number % 3 == 0) 
            number /=3;
        while(number % 5 == 0)  
            number /=5;
        return (number ==1)? true:false;
    }
}
