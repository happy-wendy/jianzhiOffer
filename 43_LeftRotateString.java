//用string自带的方法：拼接后截取
public class Solution {
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len == 0) return "";
        n = n % len;//要考虑n大于len的情况
        str += str;
        return str.substring(n, len+n);
    }
}
//自己写
public class Solution {
    public String LeftRotateString(String str,int n) {
        if(str == null || str.length() < 2 || str.length() <= n) return str;
        char[] charArray = str.toCharArray();
        int len = charArray.length;
        reverse(charArray, 0, n-1);//按n截取，先第一部分旋转
        reverse(charArray, n, len - 1);//第二部分旋转
        reverse(charArray, 0, len - 1);//整体旋转
        return String.valueOf(charArray);
    }
    private void reverse(char[] array, int start, int end){
        char temp = ' ';
        while(start < end){
            temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }
}
