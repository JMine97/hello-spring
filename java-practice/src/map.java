import java.util.*;

public class map {
    public static void main(String[] args) {
//      HashMap<Key, Value>
        Map<String, Integer> a = new HashMap<String, Integer>();
        a.put("one", 1);
        a.put("two", 2);
        a.put("three", 3);
        a.put("four", 4);
        System.out.println(a.get("one"));
        System.out.println(a.get("two"));
        System.out.println(a.get("three"));

        System.out.println(a.entrySet()); //[four=4, one=1, two=2, three=3]

        //map은 iterator로 접근이 불가능하기 때문에 Map.Entry 인터페이스를 이용해 접근한다

        // 방법 01 : entrySet()
        for (Map.Entry<String, Integer> entry : a.entrySet()) {
            System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue());
        }

        // 방법 02 : keySet()
        for (String key : a.keySet()) {
            Integer value = a.get(key);
            System.out.println("[key]:" + key + ", [value]:" + value);
        }

//        [key]:four, [value]:4
//        [key]:one, [value]:1
//        [key]:two, [value]:2
//        [key]:three, [value]:3

    }
}
