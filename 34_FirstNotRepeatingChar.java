//01为字符建立哈希映射，映射数组的下标
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.equals("")) return -1;
        char[] chars = str.toCharArray();
        int[] arr = new int[256];
        for(int i=0; i<chars.length; i++) arr[hash(chars[i])]++;//把字符映射为数字；
        int index = 0;
        for(int i=0; i<chars.length; i++){
            if(arr[hash(chars[i])] == 1){
                index = i;
                break;
            }
        }
        return index;
    }
    private int hash(char c){
        return c + 128;
    }
}
//02 HashMap
import java.util.HashMap;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        if(len == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++){
            if(map.containsKey(str.charAt(i))){  //char[] chars = str.toCharArray();这样就不用写那么多str.charAt了
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value+1);
            }
            else{
                map.put(str.charAt(i), 1);
            }
        }
        for(int i=0; i<len; i++){
            if(map.get(str.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
//03思想同01
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
        int[] a = new int['z' + 1];//记得+1，不然遇到 z 会下标过界异常。 
        for(char c : chars){
            a[(int) c]++;
        }
        for(int i = 0; i<chars.length; i++){
            if(a[(int)chars[i]] == 1) 
                return i;
        }
        return -1;
    }
}
//python
# -*- coding:utf-8 -*-
from collections import Counter//python2.7可能没有Counter
class Solution:
    def FirstNotRepeatingChar(self, s):
        # write code here
        if not s: return -1
        count = Counter(s)
        for i, c in enumerate(s):
            if count(c) == 1:
                return i
