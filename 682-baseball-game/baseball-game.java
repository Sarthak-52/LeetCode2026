class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String x : operations){
            if(x.equals("+")){
                int top = stack.pop();
                int newScore = top + stack.peek();

                stack.push(top);
                stack.push(newScore);
            }else if(x.equals("D"))
                stack.push(stack.peek() * 2);
            else if(x.equals("C"))
                stack.pop();
            else
                stack.push(Integer.parseInt(x));
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        return sum;
    }
}