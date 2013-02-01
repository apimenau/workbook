package workbook.java.core.collections.map;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Примеры использования HashMap
 * User: Andrei_Pimenau
 * Date: 1.2.13
 */
public class TestingMapHelper {
    private static Map<String, String> mapa;

    public TestingMapHelper(Map map) {
        this.mapa = map;
        init();
    }

    private void init() {
        for (int i = 0; i < 10; i++) {
            //add something to map
            mapa.put("key" + i, "value" + i);
        }
    }

    public void test() {
        print();
        delete();
        iterateAll();
        find();
        addMapToMap();
        check();
        clear();
        addingNull();
        rewritingElem();
        multiThreadStepping();
    }

    private void rewritingElem() {
        System.out.println("---- rewriting elem");
        mapa.clear();
        mapa.put("key", "val1");
        mapa.put("key", "val2");
        print();
    }

    private void addingNull() {
        System.out.println("---- adding null");
        mapa.clear();
        mapa.put(null, null);
        print();
    }

    private void multiThreadStepping() {
        System.out.println("---- multi thread test");
        mapa.clear();
        init();
        print();
        Thread thread = makeSteppingThread();
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mapa.remove("key0");
        mapa.remove("key2");
        mapa.remove("key1");
        mapa.remove("key8");
        mapa.remove("key9");
    }

    private Thread makeSteppingThread() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (Map.Entry<String, String> entry : mapa.entrySet()) {
                        System.out.println(entry);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (ConcurrentModificationException ex) {
                    System.out.println("-- exception: " + ex);
                }
            }
        });
    }

    private void clear() {
        System.out.println("---- clear");
        mapa.clear();
        print();
    }

    private void check() {
        System.out.println("---- do some checks");
        System.out.println(mapa.isEmpty());
        System.out.println(mapa.containsKey("zzz"));
        System.out.println(mapa.containsValue("value2"));
    }

    private void addMapToMap() {
        System.out.println("---- add map to map");
        Map<String, String> zu = new HashMap<>();
        zu.put("new key 1", UUID.randomUUID().toString());
        zu.put("new key 2", UUID.randomUUID().toString());
        zu.put("new key 3", UUID.randomUUID().toString());
        mapa.putAll(zu);
        print();
    }

    private void find() {
        System.out.println("---- find element");
        System.out.println(findOne("zzz"));
        System.out.println(findOne("key2"));
    }

    private String findOne(String key) {
        System.out.print(key + "=");
        return mapa.get(key);
    }

    private void iterateAll() {
        System.out.println("---- correct iteration through all records");
        for (Map.Entry<String, String> entry : mapa.entrySet()) {
            System.out.println(entry);
        }
    }

    private void delete() {
        System.out.println("---- delete element");
        mapa.remove("key5");
        print();
    }

    private void print() {
        System.out.println(mapa);
        System.out.println(mapa.keySet());
        System.out.println(mapa.values());
    }

}
