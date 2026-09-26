class Solution {
    public int climbStairs(int n) {
        if(n<=1)
            return n;
        int current = 1;
        int previous = 1;
        int next;
        for(int i = 1; i < n; i++){
            next = current + previous;
            previous = current;
            current = next;
        }
        return current;
    }
}
