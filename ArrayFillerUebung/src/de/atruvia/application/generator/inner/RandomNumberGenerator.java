package de.atruvia.application.generator.inner;

import de.atruvia.application.generator.IntGenerator;

import java.util.Random;

public class RandomNumberGenerator implements IntGenerator {
    private final Random random = new Random();


    @Override
    public int next() {
        return random.nextInt();
    }
}
