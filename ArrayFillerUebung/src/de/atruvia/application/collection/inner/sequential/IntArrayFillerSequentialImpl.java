package de.atruvia.application.collection.inner.sequential;

import de.atruvia.application.collection.IntArrayFiller;
import de.atruvia.application.generator.IntGenerator;

public class IntArrayFillerSequentialImpl implements IntArrayFiller {

    private final IntGenerator generator;

    public IntArrayFillerSequentialImpl(final IntGenerator generator) {
        this.generator = generator;
    }

    @Override
    public int [] fillArray(final int[] arrayToFill) {
        for (int i = 0; i < arrayToFill.length; i++) {
            arrayToFill[i] = generator.next();
        }
        return arrayToFill;
    }

}
