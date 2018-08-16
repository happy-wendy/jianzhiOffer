//01
//思路：用逻辑与&&与短路特性实现递归终止boolean ans = (n>0)&&;当n>0时，会一直递归执行Sum_Solution(n-1)直到n==0，开始return sum；
public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}

//02
public class Solution {
    public int Sum_Solution(int n) {
        int sum = (int) (Math.pow(n,2) + n);
       return sum>>1;
    }
}
