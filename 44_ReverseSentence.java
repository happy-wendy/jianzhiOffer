//法一：不用string方法，直接手写reverse
//思路是：先翻转整个句子,再逐个翻转单词
public class Solution {
    public String ReverseSentence(String str) {
        if(str == null || str.length() < 2) return str;
        char[] charArray = str.toCharArray();
        reverse(charArray, 0, charArray.length - 1);
        int start = 0, end = 0;
        while(end < charArray.length){
            if(charArray[end] != ' '){
                if(end == charArray.length - 1){//最后一个单词无空格
                    reverse(charArray, start, end);
                }
                end++;
            }else{
                reverse(charArray, start, end - 1);//当遇到空格时，把空格之前的单词翻转，并且把start置为end
                end++;
                start = end;//下一个单词的起始位置
            }
        }
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
//法二：用split方法，按空格切分放入数组，然后倒着读取即可
public class Solution {
    public String ReverseSentence(String str) {
        if(str == null || str.length() < 2) return str;
        String res = "";
        String[] arr = str.split(" ");
        int len = arr.length;
        if(len > 0){
            for(int i = len - 1; i > 0; i--){
                res += arr[i] + ' ';
            }
            res += arr[0];
        }else{
            res = str;//当全为空格时，len = 0
        }
        return res;
    }
}
