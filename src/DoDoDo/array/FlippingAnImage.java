package DoDoDo.array;

import java.util.Arrays;

/**
 * @author wangliang01 on 2019/1/18 using IDEA.
 */
public class FlippingAnImage {
    public static void main(String args[]){
        int[][] A = new int[3][];
        for(int i=0; i<3; i++) {
            int a[] = new int[]{0,1,1};
            A[i] = a;
        }

        new Solution().flipAndInvertImage(A);
    }
    static class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            reverse(A);

            return A;
        }

        private void reverse(int[][] A) {
            for(int i=0; i<A.length; i++) {
                int a[] = A[i];
                int newArray[] = Arrays.copyOf(a, a.length);
                for(int j=0; j<a.length; j++) {
                    a[j] = newArray[a.length -1 - j];
                }
            }

        }

        private void invert(int[][] A) {
            for(int i=0; i<A.length; i++) {
                int a[] = A[i];
                for(int j=0; j<A.length; j++) {
                    a[j] = 1 - a[j];
                }
            }
        }
    }
}
