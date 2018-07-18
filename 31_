//法一：暴力循环计数
public int NumberOf1Between1AndN_Solution(int n) {
    int count = 0;
    for(int i=0; i<=n; i++){
        int temp = i;
        //如果temp的任意位为1则count++
        while(temp!=0){
            if(temp%10 == 1){
                count++;
            }
            temp /= 10;
        }
    }
    return count;
}
//法二：数学规律。代码非常简单，效率也非常高，时间复杂度只有O(log10n)
public int NumberOf1Between1AndN_Solution2(int n) {
    int count = 0;
    for (int i = 1; i <= n; i *= 10) {
        int a = n / i,b = n % i;
        //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
        //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
        count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0); //可直接写为(a%10==1)*(b+1);
    }
    return count;
}
//法三：数字转为string再转为char []；占内存较大
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        while(n>0){
            String str=String.valueOf(n);
            char [] chars=str.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(chars[i]=='1')
                    count++;
            }
            n--;
        }
        return count;
    }
}
