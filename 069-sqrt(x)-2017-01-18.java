/*

Implement int sqrt(int x).

Compute and return the square root of x.

*/

public class Solution {
    public int mySqrt(int x) {
        if(x==1 || x==0)
            return x;
            
        // low is for lower bound of square root of x
        int low = x/2;
        while(low>x/low)
            low /= 2;
        //System.out.println(low);
        
        // Once we get lower bound, uppoer bound = low*2 (square root has to lie between these two values, inclusive)
        int high = low*2;
        
        if(high<=x/high)
            return high;
        
        // oldMid is used to break while loop when newMid is unchanged
        int oldMid = 0;
        while(high>low){    
            int newMid = (high+low)/2;
            if(newMid==oldMid)
                break;
            if(newMid>x/newMid)
                high = newMid;
            else
                low = newMid;
            oldMid = newMid;
        }
        
        return low;
        
    }   
}