class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length>h)
        {
            return 0;
        }
        int left =1;
        int right = -1;
        int ans =0;
        for(int i=0;i<piles.length;i++)
        {
            right = Math.max(right,piles[i]);
        }
        while(left<=right)
        {
            int mid = (left+right)/2;
            int time =0;
            for(int i=0;i<piles.length;i++)
            {
                time+=Math.ceil((double)(piles[i])/mid);
            }
            if(time>h)
            {
                left = mid+1;
            }else{
                ans = mid;
                right = mid-1;
            }
        }
 return ans;
        }
    
}