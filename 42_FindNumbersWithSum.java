//题目：和为S的两个数字
//因为是排好序的，可用夹逼法，降至O(n)，这样也不需要考虑满足条件有多个时乘积取小了，因为离得越远乘积自然越小。
public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int pHead = 0, pEnd = array.length - 1;
        ArrayList<Integer> arr = new ArrayList<>();
        while(pHead < pEnd){
            int curSum = array[pHead] + array[pEnd];
            if(curSum == sum){
                arr.add(array[pHead]);
                arr.add(array[pEnd]);
                break;
            }
            else{
                if(curSum > sum)
                    pEnd--;
                else
                    pHead++;
            }
        }
        return arr;
    }
}
//HashMap
import java.util.ArrayList;
import java.util.HashMap;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++){
            map.put(array[i],i);
        }
        for(int i=0; i<array.length; i++){
            if(map.containsKey(sum - array[i])){
               arr.add(array[i]);
               arr.add(sum - array[i]);
               break;
            }
        }
        return arr;
    }
}
