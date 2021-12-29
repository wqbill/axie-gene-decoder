package fragment;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ColorDecoder {
    static Map<String, Map<String, String>> data = new HashMap<>();

    static {
        ObjectMapper mapper = new ObjectMapper();
        try {
            data = mapper.readValue(ColorDecoder.class.getClassLoader().getResourceAsStream("geneColorMap.json"), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String decode(String geneFragment, String clsBinary) {
        String color;
        if (Objects.equals(geneFragment, "0000")) {
            color = "ffffff";
        } else if (Objects.equals(geneFragment, "0001")) {
            color = "7a6767";
        } else {
            color = data.get(clsBinary).get(geneFragment);
        }
        return color;
    }
}
