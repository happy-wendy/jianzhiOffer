//法一：利用长度的一半
public class Solution {
    public int MoreThanHalfNum_Solution(int [] nums) {
        int majorityCount = nums.length/2;
        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }
            if (count > majorityCount) {
                return num;
            }
        }
        return 0;    
    }
}
//思路二：如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
class Solution:
    def MoreThanHalfNum_Solution(self, numbers):
        # write code here
        count = 0
        candidate = None
        for num in numbers:
            if count == 0:
                candidate = num
            count += (1 if num == candidate else -1)   
        return candidate if numbers.count(candidate) > len(numbers) / 2 else 0
//哈希表
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int[] result=new int[10];
        for(int i=0;i<array.length;i++){
            result[array[i]]++;
        }
        for(int i=0;i<result.length;i++){
            if(result[i]>array.length/2){
                return i;
            }
        }
        return 0;
    }
}
//这个哈希表的写法有报一个错
class Solution {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }
}
