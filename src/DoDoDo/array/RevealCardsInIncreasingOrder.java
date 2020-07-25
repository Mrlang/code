package DoDoDo.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangliang01 on 2019/1/16 using IDEA.
 * 950. Reveal Cards In Increasing Order
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/submissions/1
 */
public class RevealCardsInIncreasingOrder {
    public static void main(String args[]){
                new Solution().deckRevealedIncreasing(new int[]{1,2,3,4,5});
    }
    static class Solution {
        public int[] deckRevealedIncreasing(int[] deck) {
            int length = deck.length;
            Queue<Integer> index_que = new LinkedList();
            for(int i=0; i<length; i++) {
                index_que.add(i);
            }
            Arrays.sort(deck);

            int[] newArray = new int[length];
            for(int num : deck) {
                newArray[index_que.poll()] = num;
                if(!index_que.isEmpty()){
                    index_que.add(index_que.poll());
                }
            }
            return newArray;
        }
    }
}
