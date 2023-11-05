package iv.michail;

public class MyRandom {
    private static long seed = System.currentTimeMillis();

    private static int next(int bits) {
        seed = (seed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1);
        return (int) (seed >>> (48 - bits));
    }

    public static int randInt(int bound) {
        if (bound <= 0)
            throw new IllegalArgumentException("bound must be positive");

        if ((bound & -bound) == bound)  // i.e., bound is a power of 2
            return (int) ((bound * (long) next(31)) >> 31);

        int bits, val;
        do {
            bits = next(31);
            val = bits % bound;
        } while (bits - val + (bound - 1) < 0);
        return val;
    }
}
