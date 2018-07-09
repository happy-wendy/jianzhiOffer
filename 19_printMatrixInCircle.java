public void printMatrixInCircle(int[][] array){  
        if(array == null)  
            return;  
        int start = 0;  
        while(array[0].length > start*2 && array.length >start*2){  
            printOneCircle(array,start);  
            start++;  
        }  
    }  
    private void printOneCircle(int[][] array,int start){  
        int columns = array[0].length;  
        int rows = array.length;  
        int endX = columns - 1 - start;  
        int endY = rows - 1 - start;  
        //从左到右打印一行  
        for(int i = start;i <= endX ;i++){  
            int number = array[start][i];  
            System.out.print(number+",");  
        }  
        //从上到下打印一列  
        if(start <endY){  
            for(int i = start +1;i<=endY;i++){  
                int number = array[i][endX];  
                System.out.print(number+",");  
            }  
        }  
        //从右到左打印一行  
        if(start < endX && start < endY){  
            for(int i = endX -1;i>=start;i--){  
                int number = array[endY][i];  
                System.out.print(number+",");  
            }  
        }  
        //从下到上打印一列  
        if(start <endY && start <endY -1){  
            for(int i =endY -1;i>=start+1;i--){  
                int number = array[i][start];  
                System.out.print(number+",");  
            }  
        }  
    } 
    //！！！法二：
    import java.util.ArrayList;
    public class Solution {
        public ArrayList<Integer> printMatrix(int [][] array) {
            ArrayList<Integer> result = new ArrayList<Integer> ();
            if(array.length==0) return result;
            int n = array.length,m = array[0].length;
            if(m==0) return result;
            int layers = (Math.min(n,m)-1)/2+1;//这个是层数
            for(int i=0;i<layers;i++){
                for(int k = i;k<m-i;k++) result.add(array[i][k]);//左至右
                for(int j=i+1;j<n-i;j++) result.add(array[j][m-i-1]);//右上至右下
                for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--) result.add(array[n-i-1][k]);//右至左
                for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) result.add(array[j][i]);//左下至左上
            }
            return result;       
        }
    }
    //python
    def printMatrix(self, matrix):
        # write code here
        result=[]
        while(matrix):
            result+=matrix.pop(0)
            if not matrix or not matrix[0]:
                break            #if防止越界
            matrix=self.turn(matrix)
        return result
    def turn(self,matrix):
        nrow=len(matrix)
        ncol=len(matrix[0])
        newMatrix=[]
        for i in range(ncol):
            sb=[]
            for j in range(nrow):
                sb.append(matrix[j][i]) #取矩阵的每列第i列
            newMatrix.append(sb)
        newMatrix.reverse()#翻转
        return newMatrix
//很简洁
def printMatrix(self, matrix):
    res = []
    while matrix:
        res += matrix.pop(0)
        if matrix and matrix[0]:
            for row in matrix:
                res.append(row.pop())
        if matrix:
            res += matrix.pop()[::-1]
        if matrix and matrix[0]:
            for row in matrix[::-1]:
                res.append(row.pop(0))
    return res
