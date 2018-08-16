//01
//eg:5 + 7 = 12
//第一步：相加各位的值，不算进位，得到2。(101^111)
//第二步：计算进位值，得到10. 如果这一步的进位值为0，那么第一步得到的值就是最终结果。1010 = (101&111)<<1
//第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。(各位相加 010^1010=1000，进位值为100=(010&1010)<<1。继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。)
public class Solution {
    public int Add(int num1,int num2) {
        while (num2!=0) {
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = temp;
        }
        return num1;
    }
}
//02
import java.math.BigInteger;
public class Solution {
    public int Add(int num1,int num2) {
        BigInteger bi1=new BigInteger(String.valueOf(num1));
        BigInteger bi2=new BigInteger(String.valueOf(num2));
        return bi1.add(bi2).intValue();
 
    }
}
//扩展：
不使用新的变量，交换两个变量的值
方法一：基于加减法
a = a + b;
b = a - b;
a = a - b;
方法二：基于异或运算
a = a ^ b;
b = a ^ b;
a = a ^ b;
