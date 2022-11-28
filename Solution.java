class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        int count=0, max_sum=0, sum=0;
        int max_high=0, high=0, max_low=0, low=0;
        for(int i=0; i<n; i++){
            if(a[i]<0){
                sum=0;
                low=i+1;
            } else {
                sum=sum+a[i];
            }
            if(sum>max_sum){
                max_sum=sum;
                max_high=i+1;
                max_low = low;
            } else if(sum==max_sum) {
                int Max_sumL = i+1-low;
                int sumL = high-low;
                if(Max_sumL>sumL) {
                    max_high=i+1;
                    max_low = low;
                }
            }
        }
        
        ArrayList<Integer> sol=new ArrayList<>();
        for(int i=max_low; i<max_high; i++){
            sol.add(a[i]);
        }
        if(sol.size()==0) 
            sol.add(-1);
        return sol;
        // code here
    }
}