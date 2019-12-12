package leetCode.array;

/**
 * @author wangliang01 on 2019/1/15 using IDEA.
 *
 */
public class SortArrayByParity {
    public static void main(String args[]){
        int[] A = {3,1,2,4};
        Solution s = new Solution();
        s.sortArrayByParity(A);
    }

    static class Solution {
        public int[] sortArrayByParity(int[] A) {
            int[] B = new int[A.length];
            int b_even_index = 0;
            int b_odd_index = A.length-1;
            for(int i = 0; i<A.length; i++) {
                if(ifEven(A[i])) {
                    B[b_even_index] = A[i];
                    b_even_index++;
                }else{
                    B[b_odd_index] = A[i];
                    b_odd_index--;
                }
            }
            return B;
        }

        private boolean ifEven(int a) {
            if((a % 2)== 0) {
                return true;
            }
            return false;
        }



    }

}
