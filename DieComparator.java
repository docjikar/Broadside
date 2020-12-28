/*
Author: Robert Beery III

Description: An implementation of the Comparator Class to compare die in the Broadside game. Specifically intentioned
             to sort from greatest value to least.
 */

package Broadside;

import java.util.Comparator;

public class DieComparator implements Comparator<Die>
{
        @Override
        public int compare(Die o1, Die o2)
        {
            return o2.getLastRoll() - o1.getLastRoll();
        }


        @Override
        public Comparator<Die> thenComparing(Comparator<? super Die> other) {
            return null;
        }
}
