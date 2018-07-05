//法一：迭代 这里有浪费空间但比递归效率高
public class Solution {
    public int Fibonacci(int n) {
        if(n < 2){
            return n;
        }
        else{
            int[] array = new int[n+1];
            array[0] = 0;
            array[1] = 1;
            for(int i=2; i<=n; i++){
                array[i] = array[i-1] + array[i-2];
            }
            return array[n];
        }
    }
}
//法二：动态规划
public int Fibonacci(int n) {
        int pre = 0, cur = 1;
        while(n-- > 0){
            cur += pre;
            pre = cur - pre;
        }
        return pre;
    }
