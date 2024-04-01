class Solution {
    public int fib(int n) {
        if(n == 0  || n == 1)
        {
            return n;
        }


        int a =0;
        int b = 1;

        int sum =0;
        while(n >1)
        {
            sum = a + b;
            a = b ;
            b = sum ;

            n--;
        }
        return sum;
        
    }
}