//01正则表达式
public boolean isNumeric_1(char[] str) {
	String string = String.valueOf(str);
	return string.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
}
//02
//将char型数组转成字符串，再用Double的parseDouble方法转成double型数字，如果能转成功，则返回true。否则会发生NumberFormatException异常。返回false。
public boolean isNumeric(char[] str) {
	try {
	    Double.parseDouble(new String(str));
	} catch (NumberFormatException e) {
	    return false;
	}
	return true;
}

//03一步步检验
public class Solution {
    public boolean isNumeric(char[] str) {
        if(str == null || str.length == 0){
            return false;
        }
        int index = 0;
        if(str[index] == '+' || str[index] == '-'){
            index++;
        }
        if(index == str.length){
            return false;
        }
        boolean isNumeric = true;
        index = scanDigits(str, index);
        if(index < str.length){
            if(str[index] == '.'){
                index++;
                index = scanDigits(str, index);
                if(index < str.length){
                    if(str[index] == 'e' || str[index] == 'E'){
                        index++;
                        if(index == str.length){
                            isNumeric = false;
                        }
                        else{
                            isNumeric = isExponential(str, index);
                        }
                    }
                    else{
                        isNumeric = false;
                    }
                }
                else{
                    isNumeric = true;
                }
            }
            else if(str[index] == 'e' || str[index] == 'E'){
                index++;
                if(index == str.length){
                    isNumeric = false;
                }
                else{
                    isNumeric = isExponential(str, index);
                }
            }
            else{
                isNumeric = false;
            }
        }
        else{
            isNumeric = true;
        }
        return isNumeric;
    }
    private boolean isExponential(char[] str, int index){
        if(str[index] == '+' || str[index] == '-'){
            index++;
        }
        while(index < str.length && str[index] >= '0' && str[index] <= '9'){
            index++;
        }
        return (index == str.length) ? true : false;
    }
    private int scanDigits(char[] str, int index){
        while(index < str.length && str[index] >= '0' && str[index] <= '9'){
            index++;
        }
        return index;
    }
}
