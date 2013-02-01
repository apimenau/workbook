package workbook.java.core.collections.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Примеры использования HashMap
 * User: Andrei_Pimenau
 * Date: 1.2.13
 */
public class HashMapExample {

    public static void main(String... args) {
        TestingMapHelper helper = new TestingMapHelper(new HashMap());
        helper.test();

    }
}
