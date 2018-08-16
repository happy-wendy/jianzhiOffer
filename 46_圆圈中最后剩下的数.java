//01
//1. 用一个数组标志，记录该位置的小朋友是否不再回到圈中。 
//2. 每挑出一位小朋友，就将count–，直到count==0。此时的小朋友就是最后一位。
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1) return -1;
        int[] array = new int[n];
        int i = -1,step = 0, count = n;
        while(count>0){
            i++;
            if(array[i%n] == -1) continue;
            step++;
            if(step==m) {
                array[i%n]=-1;
                step = 0;
                count--;
            }
        }
        return i%n;
    }
}

//02
//f[i]=(f[i-1]+m)%i;(i>1) 这个递推公式的循环实现版,让f[i]为i个人玩游戏报m退出最后的胜利者的编号，最后的结果自然是f[n]
public class Solution
{
    public int LastRemaining_Solution(int n, int m)
    {
        if(n==0||m==0)return -1;
        int s=0;
        for(int i=2;i<=n;i++)
        {
            s=(s+m)%i;
        }   
       return s ;
    }
}

//03数学公式递推法–约瑟夫环 
public int LastRemaining_Solution(int n,int m) {
     if(n < 1 || m < 1)
         return -1;
     if(n == 1){
         return 0;
     }
     return (LastRemaining_Solution(n-1, m)+m)%n;
 }
