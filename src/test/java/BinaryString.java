import type.AxieInfo;

public class BinaryString {
    public static void main(String[] args) {
        AxieInfo axieInfo = GeneDecoder.decode("0x40000000032073141044110a1084210810a4190a10c4310c1064190610241104");
        System.out.println(axieInfo);
    }
}
