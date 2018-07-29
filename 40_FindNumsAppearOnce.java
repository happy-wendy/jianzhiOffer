//异或&分成两组（先完成一次完整的异或，取异或结果右边开始数第一位为1的indexBit,然后根据这个indexBit位来将array分为两组，每组异或即可）
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null) return;
        int num = 0;
        for(int i: array){
            num ^= i;
        }
        int index = findFirstBitIs1(num);
        for(int i: array){
            if(isBit1(i, index))
                num1[0] ^= i;
            else
                num2[0] ^= i;
        }
    }
    private int findFirstBitIs1(int num){
        int indexBit = 0;
        while((num & 1) == 0){
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }
    private boolean isBit1(int num, int index){
        num = num >> index;
        return (num & 1) == 0;
    }
}
//方法一样，但是放一个函数里实现
public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length < 2) return ;
        int myxor = 0;
        int flag = 1;
        for(int i = 0 ; i < array.length; ++ i )
            myxor ^= array[i];
        while((myxor & flag) == 0) flag <<= 1;
       // num1[0] = myxor;
        //num2[0] = myxor;
        for(int i = 0; i < array.length; ++ i ){
            if((flag & array[i]) == 0) num2[0]^= array[i];
            else num1[0]^= array[i];
        }          
    }
