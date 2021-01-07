package dailychallenge;

public class Jan6 {
    public int findKthPositive(int[] arr, int k) {
        int res = 0;
        int i = 0;
        int n = 0;
        for(int m = 1; m<1000000; m++){

            if(n < arr.length && m == arr[n]){
                n++;
                continue;
            }
            i++;
            if(i >= k){
                res = m;
                break;
            }

        }
        return res;
    }
}
