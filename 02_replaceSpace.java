//法一:replace
public class Solution {
    public String replaceSpace(StringBuffer str) {
        for(int k=0; k<str.length(); k++)
              {
              char index = str.charAt(k);
                   if(index == ' ')
                     {
                      str.replace(k, k+1, "%20");
                     }
              }
         
        return str.toString();
    }
}
//法二：StringBuild
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	if(str == null){
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                newStr.append("%20");
            }
            else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
}
//法三：
public class Solution {
    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        int oldIndex = str.length() - 1;
        for(int i = 0; i <= oldIndex ; i++){
            if(' ' == str.charAt(i))
                spaceNum++;
        }
        int newIndex = oldIndex + spaceNum * 2;
        str.setLength(newIndex + 1);
        for(; oldIndex < newIndex && oldIndex >=0; oldIndex--){
            if(' ' == str.charAt(oldIndex)){
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            }else{
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
        }
        return str.toString();
    }
}

//完整版
package my_java;
 
public class Test{
 
	//计算字符串中包含的空格个数
	public static int getBlankNum(String testString){
		int count = 0 ;
		for(int i = 0;i<testString.length();i++){
			String tempString = String.valueOf(testString.charAt(i));
			if(tempString.equals(" ")){
				count++;
			}
		}
		return count;
	}
	//打印char[] 数组
	public static void printArray(char[] testArray){
		for(char i :testArray){
			System.out.print(i);
		}
		System.out.println();
	}
	//将字符串空格转化为20%
	public static void replaceAllBlank(String testString){
		if(testString == null || testString.length() <= 0){
			return;
		}
		//字符数组初始长度
		int length = testString.length();
		//字符数组增加长度后
		int newLength = testString.length()+ getBlankNum(testString)*2;
		char[] tempArray = new char[newLength];
		System.arraycopy(testString.toCharArray(), 0, tempArray, 0, testString.toCharArray().length);
		int indexofOriginal = length - 1;
		int indexofNew = newLength -1;
		System.out.println("未替换空格时的字符串：");
		printArray(testString.toCharArray());
		while(indexofOriginal >=0 && indexofOriginal != indexofNew){
			if(tempArray[indexofOriginal]==' '){
				tempArray[indexofNew--]='0';
				tempArray[indexofNew--]='2';
				tempArray[indexofNew--]='%';
			}else{
				tempArray[indexofNew--]= tempArray[indexofOriginal];
			}
			indexofOriginal--;
		}
		System.out.println("替换空格后的字符串：");
		printArray(tempArray);
	}
	public static void main(String[] args){
		String str = "We are happy";
		replaceAllBlank(str);
	}
}
