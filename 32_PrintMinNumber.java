//法一：01 Comparator类
import java.util.*;
import java.lang.*;
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] str = new String[len];
        //StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String s1, String s2){
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        //for(int i=0; i<len; i++){
            //sb.append(str[i]);
        //}
        //return sb.toString();
        String s = "";
        for(int i=0; i<len; i++){
            s += str[i];
        }
        return s;
    }
}
//02
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Solution {
    public String PrintMinNumber(int [] numbers) {
        int n;
        String s="";
        ArrayList<Integer> list=new ArrayList<Integer>();
        n=numbers.length;
         
        for(int i=0;i<n;i++){
            list.add(numbers[i]);//将数组放入arrayList中
        }
        //实现了Comparator接口的compare方法，将集合元素按照compare方法的规则进行排序
        Collections.sort(list,new Comparator<Integer>(){
         
            @Override
            public int compare(Integer str1, Integer str2) {
                // TODO Auto-generated method stub         
                    String s1=str1+""+str2;
                    String s2=str2+""+str1;
                     
                    return s1.compareTo(s2);
                }
            });
         
        for(int j:list){
            s+=j;
        }
        return s;
    }
}
//python
class Solution:
    def PrintMinNumber(self, numbers):
        # write code here
        if not numbers: return ""
        numbers = list(map(str, numbers))
        numbers.sort(cmp=lambda x, y: cmp(x + y, y + x))
        return "".join(numbers).lstrip('0') or'0'
        //去掉第一个0再拼接或为0；
