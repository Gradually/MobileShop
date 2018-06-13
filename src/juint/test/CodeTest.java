package juint.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author WuYuchen
 * @date 2017-11-12 01:21
 */

public class CodeTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.remove(1);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
