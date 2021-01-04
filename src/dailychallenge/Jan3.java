package dailychallenge;

import java.util.LinkedList;

public class Jan3 {
    /** Backtracking question */

    //    int res = 0;
    //    public int countArrangement(int n) {
    //        LinkedList<Integer> track = new LinkedList<>();
    //        backtrack(n, track);
    //        return res;
    //    }
    //    void backtrack(int n, LinkedList<Integer> track){
    //        if (track.size() == n)
    //            res++;
    //
    //        for(int i=1;i<=n;i++){
    //                                                           it should be track.size() + 1  T.T
    //            if (track.size()!=0 && (track.contains(i) && i%track.size() != 0 && track.size()%i != 0 ))
    //                continue;
    //            track.add(i);
    //            backtrack(n, track);
    //            track.removeLast();
    //        }
    //    }
    //
    /** my solution with the backtracking template, but the performance is not good */
    class Solution {
        int res = 0;
        public int countArrangement(int n) {
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(n, track);
            return res;
        }
        void backtrack(int n, LinkedList<Integer> track){
            if (track.size() == n){
                res++;
                return;
            }

            for(int i=1;i<=n;i++){
                if (track.contains(i) || i%(track.size()+1)!= 0 && (track.size()+1)%i != 0 )
                    continue;
                track.add(i);
                backtrack(n, track);
                track.removeLast();
            }
        }
    }

    /** improved version, since the element value is same as the index, the track array can be optimized */
    int count = 0;
    public int countArrangement2(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }
    public void calculate(int N, int pos, boolean[] visited) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }

}
