//01用boolean数组
public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean[] k = new boolean[length];
        for(int i = 0; i < length; i++){
            if(k[numbers[i]] == true){
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }
}

//
public boolean duplicate(int numbers[],int length,int [] duplication) {
    StringBuffer sb = new StringBuffer(); 
        for(int i = 0; i < length; i++){
                sb.append(numbers[i] + "");
            }
        for(int j = 0; j < length; j++){
            if(sb.indexOf(numbers[j]+"") != sb.lastIndexOf(numbers[j]+"")){//子字符串最先和最后出现的位置相等说明只出现了一次，indexf没出现返回-1
                duplication[0] = numbers[j];
                return true;
            }
        }
        return false;
    }
