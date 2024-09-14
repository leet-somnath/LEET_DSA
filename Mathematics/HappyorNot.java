class Solution {
    //Algo Used: Fast and Slow pointer method
    public boolean isHappy(int n) {
       int slow= n;
        int fast= n;
        
        do{
            slow= square(slow); // noral square of a number(moving ahead 1 time)
            fast= square(square(fast)); // square of sqaure of number(moving ahead 2 times)
            if(slow == 1){
                return true;
            }
        }while(slow != fast); // if fast and slow meets then cycle is present, we can never reach to 1 so return false.
        
        return false;
    }
    
    
    public int square(int num){ // taking square of the number
        int ans=0;
        while(num > 0){
            int rem= num % 10;
            ans+= rem*rem;
            num= num / 10;
        }
        return ans; 
    }
}