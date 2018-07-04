import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        while(!stack1.empty()){
            Integer tempNode = stack1.pop();
            stack2.push(tempNode);
        }
        int result = stack2.pop();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}

//法二：python 减少重复挪动
class Solution:
    def __init__(self):
        self.stackIn = []
        self.stackOut = []

    def push(self, node):
        self.stackIn.append(node)

    def pop(self):
        if not self.stackOut:
            while self.stackIn:
                self.stackOut.append(self.stackIn.pop(-1))
        return self.stackOut.pop(-1)
