import fragment.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@Builder
public class AxieInfo {
    /**
     * @param genes raw string data starts with 0x
     */
    AxieInfo(String genes) {
        this.genes = genes;
        StringBuilder binary = new StringBuilder(new BigInteger(genes.substring(2), 16).toString(2));
        for (int i = 0; i < 256 - binary.length(); i++) {
            binary.insert(0, "0");
        }
        this.binary = binary.toString();
        // todo 单例
        this.cls = new ClassDecoder().decode(binary.substring(0, 4));
        this.region = new RegionDecoder().decode(binary.substring(8, 13));
        this.pattern = new PatternDecoder().decode(binary.substring(34, 52));
        this.color = new ColorDecoder().decode(binary.substring(52, 64));
        this.eyes = new EyesDecoder().decode(binary.substring(64, 96));
        this.mouth = new MouthDecoder().decode(binary.substring(96, 128));
        this.ears = new EarsDecoder().decode(binary.substring(128, 160));
        this.horn = new HornDecoder().decode(binary.substring(160, 192));
        this.back = new BackDecoder().decode(binary.substring(192, 224));
        this.tail = new TailDecoder().decode(binary.substring(224, 256));

    }

    private String binary;
    private String genes;
    private String cls;
    private String region;
    private String pattern;
    private String color;
    private String eyes;
    private String mouth;
    private String ears;
    private String horn;
    private String back;
    private String tail;
}
