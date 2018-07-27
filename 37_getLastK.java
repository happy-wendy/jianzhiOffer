//数字在排序数组中出现的次数:统计一个数字在排序数组中出现的次数。
//思路：看到排序就想到二分nlog(n)降低时间复杂度
        int length = array.length;
        if(length == 0){
            return 0;
        }
        int firstK = getFirstK(array, k, 0, length-1);
        int lastK = getLastK(array, k, 0, length-1);
        if(firstK != -1 && lastK != -1){
             return lastK - firstK + 1;
        }
        return 0;
    }
    //递归写法
    private int getFirstK(int [] array , int k, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if(array[mid] > k){
            return getFirstK(array, k, start, mid-1);
        }else if (array[mid] < k){
            return getFirstK(array, k, mid+1, end);
        }else if(mid-1 >=0 && array[mid-1] == k){
            return getFirstK(array, k, start, mid-1);
        }else{
            return mid;
        }
    }
    //循环写法
    private int getLastK(int [] array , int k, int start, int end){
        int length = array.length;
        int mid = (start + end) >> 1;
        while(start <= end){
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid+1 < length && array[mid+1] == k){
                start = mid+1;
            }else{
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
//思路二：直接计数
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        int len=array.length;
        int count = 0;
        for(int i=0; i<len; i++){
            if(array[i] == k){
                count++;
            }
        }
        return count;
    }
}
//思路三：笨到用arr[array[i]]了，这得耗多少内存呀，还不如用hashtable

