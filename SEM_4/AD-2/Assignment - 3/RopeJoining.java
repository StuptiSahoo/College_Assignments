package GreedyAlgorithm;
import java.util.PriorityQueue;
//Given N member of ropes of various lengths.You need to join these ropes to make a single ropes.

//The cost of joining various length of length A and B is (A+B) which is their Combined length. 
//You need to find the minimuon Cost of joining all the ropes.The minimum Cost of joining rope is obtained when we always join the two smallest ropes.

//Example:
//Ropes: [4,3,2,6]
//Output: 29
public class RopeJoining {

    public static int minCost(int ropes[], int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropes) {
            minHeap.offer(rope);
        }
        int cost = 0;
        while (minHeap.size() > 1) {
            int min1 = minHeap.poll();
            int min2 = minHeap.poll();
            int mergedRope = min1 + min2;
            cost += mergedRope;
            minHeap.offer(mergedRope);
        }
        return cost;
    }

    public static void main(String[] args) {
        int ropes[] = { 4, 3, 2, 6, 8, 12, 1, 9 };
        int n = ropes.length;

        int cost = minCost(ropes, n);
        System.out.println("Minimum cost of joining all ropes: " + cost);
    }
}

