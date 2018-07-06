//法一：Math.abs O(exp)
import java.lang.Math;
public class Solution {
    public double Power(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        double ans = 1.0;
        int exp = Math.abs(exponent);
        for(int i=0; i<exp; i++){
            ans *= base;
        }
        return exponent>0 ? ans:1/ans;
  }
}
//法二：位运算（效率更高） O(log(exp))
//使用二进制，例如11^1101 = 11^0001*11^0100*11^1000,通过判断整数exponent的二进制数字每一位上是不是为1，来决定是不是要乘以对应位数的底数次方
 public double Power(double base, int exponent) {
        if(base>=-0.000001&&base<=0.000001){
            return 0;
        }
        int e = exponent > 0 ? exponent : -exponent;
        double result = 1.0;
        double current = base;
        while(e!=0){
            if((exponent & 1) == 1){
                result *= current;
            }
            current *= base;
            e>>=1;
        }
        return exponent > 0 ? result:1/result;
  }
//法三：python
class Solution:
    def Power(self, base, exp):
        # write code here
        if exp < 1:
            return 1 / self.getPower(base, -exp)
        else:
            return self.getPower(base, exp)
    def getPower(self, base, exp):
        if exp == 0:
            return 1
        elif exp == 1:
            return base
        res = self.Power(base, exp >> 1)
        res *= res
        if exp & 1 == 1:
            res *= base
        return res
