package array;

import java.util.TreeMap;

public class L729 {
    /**
     *     729. My Calendar I
     *     this problem looks like the meeting room schedule question, but solution uses tree map
     *     which is something I didn't know.
     *     https://www.baeldung.com/java-treemap
     *     In one word, treemap is a sorted hashmap
     *
     *     public K TreeMap.lowerKey(K key)
     * Parameters: This method takes a mandatory parameter key which is this is the key to be matched
     * Return Value: This method returns the greatest key strictly less than to key, or null if there is no such key.
     **/
//    @Test
//    public void givenTreeMap_whenPerformsQueries_thenCorrect() {
//        TreeMap<Integer, String> map = new TreeMap<>();
//        map.put(3, "val");
//        map.put(2, "val");
//        map.put(1, "val");
//        map.put(5, "val");
//        map.put(4, "val");
//
//        Integer highestKey = map.lastKey();
//        Integer lowestKey = map.firstKey();
//        Set<Integer> keysLessThan3 = map.headMap(3).keySet();
//        Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();
//
//        assertEquals(new Integer(5), highestKey);
//        assertEquals(new Integer(1), lowestKey);
//        assertEquals("[1, 2]", keysLessThan3.toString());
//        assertEquals("[3, 4, 5]", keysGreaterThanEqTo3.toString());
//    }

    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer low = map.lowerKey(end);

        if(low == null || map.get(low) <= start) {
            map.put(start, end);
            return true;
        }
        return false;
    }


}
