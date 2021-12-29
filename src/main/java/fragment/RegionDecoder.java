package fragment;

import java.util.HashMap;

public class RegionDecoder {

    static HashMap<String, String> data = new HashMap<>();

    static {
        data.put("00000", "global");
        data.put("00001", "japan");
    }

    public static String decode(String geneFragment) {
        return data.get(geneFragment);
    }
}
