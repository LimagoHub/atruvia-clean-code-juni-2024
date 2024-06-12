package de.atruvia.application.generator.inner.random;

import de.atruvia.application.generator.IntGenerator;
import de.atruvia.application.generator.IntGeneratorBuilder;

import java.util.random.RandomGenerator;

public class RandomGeneratorBuilderImpl implements IntGeneratorBuilder {
    @Override
    public IntGenerator create() {
        return new RandomNumberGenerator();
    }
}
