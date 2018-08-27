//01 new三个数组
import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
        if(A == null || A.length <= 0) return null;
        int[] b = new int[A.length];
        int[] c = new int[A.length];
        int[] d = new int[A.length];
        c[A.length-1] = 1;
        d[0] = 1;
        for(int i = 1; i < A.length; i++){
            d[i] = d[i-1] * A[i-1];
        }
        for(int i = A.length-1; i > 0; i--){
            c[i-1] = c[i] * A[i];
        }
        for(int i = 0; i < A.length; i++){
            b[i] = d[i] * c[i];
        }
        return b;
    }
}
//02 new一个数组
public class Solution {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0 ){
            B[0] = 1;
            //计算下三角连乘
            for(int i = 1; i < length; i++){
                B[i] = B[i-1] * A[i-1];
            }
            int temp = 1;
            //计算上三角
            for(int j = length-1; j > 0; j--){
                temp *= A[j];//上三角
                B[j-1] *= temp;//修改第一轮计算过B[i]
            }
        }
        return B;
    }
}
