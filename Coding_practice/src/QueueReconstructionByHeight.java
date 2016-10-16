import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by Mathurs on 10/16/16.
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h.
 * Write an algorithm to reconstruct the queue.

 Note:
 The number of people is less than 1,100.

 Example

 Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

public class QueueReconstructionByHeight {

    public static int[][] reconstructQueue(int[][] people) {

        LinkedList<int[]> result = new LinkedList<int[]>();

        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return o2[0] - o1[0];
                else
                    return o1[1] - o2[1];
            }
        });

        for(int[] i : people)
            System.out.print("["+i[0]+","+i[1]+"]");


        for(int i = 0 ; i < people.length ; i++){
            result.add(people[i][1], people[i]);
        }

        System.out.println();
        for(int[] i : result)
            System.out.print("["+i[0]+","+i[1]+"]");


        return result.toArray(new int[people.length][2]);
    }

    public static void main(String args[]){
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(people);

    }
}
