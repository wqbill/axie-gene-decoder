package type;

import fragment.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
@Builder
public class AxieInfo {
    /**
     * @param genes raw string data starts with 0x
     */
    public AxieInfo(String genes) {
        this.genes = genes;
        StringBuilder binary = new StringBuilder(new BigInteger(genes.substring(2), 16).toString(2));
        int binaryLength = binary.length();
        for (int i = 0; i < 256 - binaryLength; i++) {
            binary.insert(0, "0");
        }
        this.binary = binary.toString();
        this.cls = ClassDecoder.decode(binary.substring(0, 4));
        this.region = RegionDecoder.decode(binary.substring(8, 13));
        this.pattern = PatternDecoder.decode(binary.substring(34, 52));
        this.color = ColorDecoder.decode(binary.substring(52, 64), binary.substring(0, 4));
        this.eyes = PartDecoder.decode("eyes", binary.substring(64, 96), region);
        this.mouth = PartDecoder.decode("mouth", binary.substring(96, 128), region);
        this.ears = PartDecoder.decode("ears", binary.substring(128, 160), region);
        this.horn = PartDecoder.decode("horn", binary.substring(160, 192), region);
        this.back = PartDecoder.decode("back", binary.substring(192, 224), region);
        this.tail = PartDecoder.decode("tail", binary.substring(224, 256), region);
        calculate();
    }

    private void calculate() {
        geneticPurity = (calculateGeneticPurity(this.eyes) + calculateGeneticPurity(this.mouth) + calculateGeneticPurity(this.ears)
                + calculateGeneticPurity(this.horn) + calculateGeneticPurity(this.back) + calculateGeneticPurity(this.tail)) / 6;
        dominantGeneticPurity = (calculateDominantGeneticPurity(this.mouth) + calculateDominantGeneticPurity(this.horn) + calculateDominantGeneticPurity(this.back) + calculateDominantGeneticPurity(this.tail)) / 4;
    }

    private double calculateGeneticPurity(Fragment part) {
        double[] rates = new double[]{0.75, 0.1875, 0.0625};
        return (Objects.equals(cls, ((Map<String, String>) part.getD()).get("class")) ? rates[0] : 0)
                + (Objects.equals(cls, ((Map<String, String>) part.getR1()).get("class")) ? rates[1] : 0)
                + (Objects.equals(cls, ((Map<String, String>) part.getR2()).get("class")) ? rates[2] : 0);
    }

    private double calculateDominantGeneticPurity(Fragment part) {
        double[] rates = new double[]{0.75, 0.1875, 0.0625};
        return rates[0]
                + (Objects.equals(part.getD(), part.getR1()) ? rates[1] : 0)
                + (Objects.equals(part.getD(), part.getR2()) ? rates[2] : 0);
    }

    private String binary;
    private String genes;
    private String cls;
    private String region;
    private Fragment pattern;
    private String color;
    private Fragment eyes;
    private Fragment mouth;
    private Fragment ears;
    private Fragment horn;
    private Fragment back;
    private Fragment tail;

    /**
     * official algorithm
     */
    private double geneticPurity;

    /**
     * custom algorithm
     * calculate dominant genes of 4 parts (back mouth horn tail) only
     */
    private double dominantGeneticPurity;
}
