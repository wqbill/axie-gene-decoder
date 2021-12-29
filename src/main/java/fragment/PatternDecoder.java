package fragment;

import type.Fragment;

public class PatternDecoder {
    public static Fragment decode(String geneFragment) {
        return Fragment.builder().d(geneFragment.substring(0, 6)).r1(geneFragment.substring(6, 12)).r2(geneFragment.substring(12, 18)).build();
    }
}
