package fragment;

import com.fasterxml.jackson.databind.ObjectMapper;
import type.Fragment;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PartDecoder {
    public static Fragment decode(String part, String geneFragment, String region) {
        String skinBinary = geneFragment.substring(0, 2);
        boolean mystic = Objects.equals(skinBinary, "11");
        String dClass = ClassDecoder.decode(geneFragment.substring(2, 6));
        String dBin = geneFragment.substring(6, 12);
        String dName = getPartName(dClass, part, region, dBin, skinBinary);
        String r1Class = ClassDecoder.decode(geneFragment.substring(12, 16));
        String r1Bin = geneFragment.substring(16, 22);
        String r1Name = getPartName(r1Class, part, region, r1Bin, null);
        String r2Class = ClassDecoder.decode(geneFragment.substring(22, 26));
        String r2Bin = geneFragment.substring(26, 32);
        String r2Name = getPartName(r2Class, part, region, r2Bin, null);
        return Fragment.builder().d(getPartFromName(part, dName)).r1(getPartFromName(part, r1Name)).r2(getPartFromName(part, r2Name)).mystic(mystic).build();
    }

    private static String getPartName(String cls, String part, String region, String binary, String skinBinary) {
        String trait;
        if (binarytraits.get(cls).get(part).containsKey(binary)) {
            if (Objects.equals(skinBinary, "11")) {
                trait = binarytraits.get(cls).get(part).get(binary).get("mystic");
            } else if (Objects.equals(skinBinary, "10")) {
                trait = binarytraits.get(cls).get(part).get(binary).get("xmas");
            } else if (binarytraits.get(cls).get(part).get(binary).containsKey(region)) {
                trait = binarytraits.get(cls).get(part).get(binary).get(region);
            } else if (binarytraits.get(cls).get(part).get(binary).containsKey("global")) {
                trait = binarytraits.get(cls).get(part).get(binary).get("global");
            } else {
                trait = "UNKNOWN Regional " + cls + " " + part;
            }
        } else {
            trait = "UNKNOWN " + cls + " " + part;
        }
        return trait;
    }

    private static Map<String, String> getPartFromName(String traitType, String partName) {
        String traitId = traitType.toLowerCase() + "-" + partName.toLowerCase().replace(" ", "-").replace("'", "");
        return bodyPartsMap.get(traitId);
    }

    static Map<String, Map<String, Map<String, Map<String, String>>>> binarytraits;
    static List<Map<String, String>> bodyParts;
    static Map<String, Map<String, String>> bodyPartsMap = new HashMap<>();

    static {
        InputStream is = PartDecoder.class.getClassLoader().getResourceAsStream("binarytraits.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            binarytraits = mapper.readValue(is, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is2 = PartDecoder.class.getClassLoader().getResourceAsStream("body-parts.json");
        ObjectMapper mapper2 = new ObjectMapper();
        try {
            bodyParts = mapper2.readValue(is2, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bodyParts.forEach(x -> {
            if (x != null && x.containsKey("partId")) bodyPartsMap.put(x.get("partId"), x);
            else {
                System.out.println(x);
            }
        });
    }
}
