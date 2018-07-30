//我写的看起来复杂度有点大,但是这三种写法提交后的结果我写的时间最少，占内存也最少。
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        for(int i=1; i<sum; i++){
            for(int j=1; j<sum; j++){
                if(i*j+j*(j-1)/2==sum){
                    ArrayList<Integer> array = new ArrayList();
                    for(int k=0; k<j; k++){
                        array.add(i+k);
                    }
                    list.add(array);
                }
            }
        }
        return list;
    }
}
//减掉第二层循环后
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> >  list = new ArrayList<ArrayList<Integer> > ();
        if(sum==1)return list;
        int n = (int) (Math.ceil((Math.sqrt(8*sum+1)-1)/2));
        int tmp = 0;
        int num = 0;
        for (int i = n;i>1;i--){
            tmp = (i + 1)*i/2;
            if ((sum - tmp) % i == 0) {
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                num = (sum - tmp)/i;
                for (int a=1;a<=i;a++){
                    arrayList.add(num+a);
                }
                list.add(arrayList);
            }
        }
        return list;
    }
}
//利用等差公式，sum=k+n*(n-1)/2,时间复杂度为根号n
import java.lang.Math;
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        for (int n = (int)Math.sqrt(2*sum); n>=2 ;n--){
            if ((n&1) == 1 && sum%n == 0 || (sum%n)*2 == n){
                ArrayList<Integer> array = new ArrayList<Integer>();
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    array.add(k);
                }
                list.add(array);
            }
        }
        return list;
    }
}
//02滑动窗口法：令初始区间为[1,2]，<sum则扩大区间[1,2,3],>sum则在左边去掉一个数[2,3].若sum=5，就这样找到了一组.打印[2,3]
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        int startIndex = 1, endIndex = 2, curSum = 3, mid = sum / 2;
        while (endIndex < mid || startIndex < endIndex) {
            if (curSum == sum) {
                list.add (this.li(startIndex, endIndex));
            }
            endIndex ++;
            curSum += endIndex;
            while (curSum > sum) {
                curSum -= startIndex;
                startIndex ++;
            }
        }
        return list;
    }
    private ArrayList<Integer> li(int startIndex, int endIndex) {
        ArrayList<Integer> resList = new ArrayList();
        for (int i=startIndex; i<=endIndex; i++) {
            resList.add(i);
        }
        return resList;
    }
}
