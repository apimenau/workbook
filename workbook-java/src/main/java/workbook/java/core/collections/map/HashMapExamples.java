package workbook.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Примеры использования HashMap
 * User: Andrei_Pimenau
 * Date: 1.2.13
 */
public class HashMapExamples {
    private static Map<String, String> mapa;

    static {
        //create hashMap
        mapa = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            //add something to map
            mapa.put("key" + i, "value" + i);
        }
    }

    public static void main(String... args) {
        print();
        delete();

    }

    private static void delete() {
        //delete element
        mapa.remove("key5");
        print();
    }

    private static void print() {
        //to string
        System.out.println(mapa);
    }

}
