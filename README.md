Axie Gene Decoder
======

Description
------

Axie Infinity is one of the top games on Ethereum/Ronin.
This project is designed to decode raw genes data of Axie in the game.


Maven Repository
------

```xml
<dependency>
    <groupId>io.github.wqbill</groupId>
    <artifactId>axie-gene-decoder</artifactId>
    <version>1.0.0</version>
</dependency>
```

Example
------

```java
AxieInfo axieInfo = GeneDecoder.decode("0x40000000032073141044110a1084210810a4190a10c4310c1064190610241104");
System.out.println(axieInfo);
```

Output
------

```json
AxieInfo(binary=0100000000000000000000000000000000000011001000000111001100010100000100000100010000010001000010100001000010000100001000010000100000010000101001000001100100001010000100001100010000110001000011000001000001100100000110010000011000010000001001000001000100000100, genes=0x40000000032073141044110a1084210810a4190a10c4310c1064190610241104, cls=aquatic, region=global, pattern=Fragment(d=000011, r1=001000, r2=000111, mystic=false), color=null, eyes=Fragment(d={partId=eyes-clear, class=aquatic, specialGenes=null, type=eyes, name=Clear}, r1={partId=eyes-clear, class=aquatic, specialGenes=null, type=eyes, name=Clear}, r2={partId=eyes-telescope, class=aquatic, specialGenes=null, type=eyes, name=Telescope}, mystic=false), mouth=Fragment(d={partId=mouth-risky-fish, class=aquatic, specialGenes=null, type=mouth, name=Risky Fish}, r1={partId=mouth-risky-fish, class=aquatic, specialGenes=null, type=mouth, name=Risky Fish}, r2={partId=mouth-risky-fish, class=aquatic, specialGenes=null, type=mouth, name=Risky Fish}, mystic=false), ears=Fragment(d={partId=ears-gill, class=aquatic, specialGenes=null, type=ears, name=Gill}, r1={partId=ears-bubblemaker, class=aquatic, specialGenes=null, type=ears, name=Bubblemaker}, r2={partId=ears-gill, class=aquatic, specialGenes=null, type=ears, name=Gill}, mystic=false), horn=Fragment(d={partId=horn-shoal-star, class=aquatic, specialGenes=null, type=horn, name=Shoal Star}, r1={partId=horn-shoal-star, class=aquatic, specialGenes=null, type=horn, name=Shoal Star}, r2={partId=horn-shoal-star, class=aquatic, specialGenes=null, type=horn, name=Shoal Star}, mystic=false), back=Fragment(d={partId=back-goldfish, class=aquatic, specialGenes=null, type=back, name=Goldfish}, r1={partId=back-goldfish, class=aquatic, specialGenes=null, type=back, name=Goldfish}, r2={partId=back-goldfish, class=aquatic, specialGenes=null, type=back, name=Goldfish}, mystic=false), tail=Fragment(d={partId=tail-koi, class=aquatic, specialGenes=null, type=tail, name=Koi}, r1={partId=tail-nimo, class=aquatic, specialGenes=null, type=tail, name=Nimo}, r2={partId=tail-nimo, class=aquatic, specialGenes=null, type=tail, name=Nimo}, mystic=false), geneticPurity=1.0, dominantGeneticPurity=0.9375)
```