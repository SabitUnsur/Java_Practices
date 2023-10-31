package Collections;

import java.util.Comparator;

public class OrderByNoComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer integer, Integer t1) {
        return integer-t1;
    }
}
