package fragment;

import java.util.HashMap;

public class ClassDecoder {
    static HashMap<String, String> data = new HashMap<>();

    static {
        data.put("0000", "beast");
        data.put("0001", "bug");
        data.put("0010", "bird");
        data.put("0011", "plant");
        data.put("0100", "aquatic");
        data.put("0101", "reptile");
        data.put("1000", "mech");
        data.put("1001", "dawn");
        data.put("1010", "dusk");
    }

    public static String decode(String geneFragment) {
        return data.get(geneFragment);
    }
}
