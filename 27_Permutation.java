
//回溯法之递归
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
 
public class Solution {
    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(p.Permutation("abc").toString());
    }
 
    public ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList)res;
    }
 
    public void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);//也可以用SwapUtil.swap(cs, i, j);
                PermutationHelper(cs, i+1, list);
                swap(cs, i, j);//回到上层，恢复后进行下一轮循环迭代
            }
        }
    }
 
    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}

//法二-迭代算法：字典生成算法
public ArrayList<String> Permutation(String str) {
       ArrayList<String> res = new ArrayList<>();
 
        if (str != null && str.length() > 0) {
            char[] seq = str.toCharArray();
            Arrays.sort(seq); //排列
            res.add(String.valueOf(seq)); //先输出一个解
 
            int len = seq.length;
            while (true) {
                int p = len - 1, q;
                //从后向前找一个seq[p - 1] < seq[p]
                while (p >= 1 && seq[p - 1] >= seq[p]) --p;
                if (p == 0) break; //已经是“最小”的排列，退出
                //从p向后找最后一个比seq[p]大的数
                q = p; --p;
                while (q < len && seq[q] > seq[p]) q++;
                --q;
                //交换这两个位置上的值
                swap(seq, q, p);
                //将p之后的序列倒序排列
                reverse(seq, p + 1);
                res.add(String.valueOf(seq));
            }
        }
 
        return res;
    }
     
    public static void reverse(char[] seq, int start) {
        int len;
        if(seq == null || (len = seq.length) <= start)
            return;
        for (int i = 0; i < ((len - start) >> 1); i++) {
            int p = start + i, q = len - 1 - i;
            if (p != q)
                swap(seq, p, q);
        }
    }
