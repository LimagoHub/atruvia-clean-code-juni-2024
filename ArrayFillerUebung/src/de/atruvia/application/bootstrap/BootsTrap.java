package de.atruvia.application.bootstrap;

import de.atruvia.application.client.Client;
import de.atruvia.application.client.inner.ClientImpl;
import de.atruvia.application.collection.IntArrayFiller;
import de.atruvia.application.collection.inner.decorator.IntArrayFillerBenchmarkDecorator;
import de.atruvia.application.collection.inner.sequential.ArrayFillerSequentialImpl;
import de.atruvia.application.generator.IntGenerator;
import de.atruvia.application.generator.inner.RandomNumberGenerator;

public class BootsTrap {

    public void startApplication() {
        for (int treadCount = 1; treadCount <= Runtime.getRuntime().availableProcessors() + 1; treadCount++) {
            run(treadCount);
        }
    }

    private void run(final int treadCount) {

        System.out.print("Running with " + treadCount + " threads...");

        IntGenerator generator = createIntGenerator();
        IntArrayFiller arrayFiller = createIntFiller(generator);
        Client client = createClient(arrayFiller);
        client.doSomethingWithLargeArray();

    }

    private static IntGenerator createIntGenerator() {
        return new RandomNumberGenerator();
    }

    private static IntArrayFiller createIntFiller(IntGenerator generator) {
        IntArrayFiller result = new ArrayFillerSequentialImpl(generator);
        result = new IntArrayFillerBenchmarkDecorator(result);
        return result;
    }

    private static Client createClient(IntArrayFiller arrayFiller) {
        return new ClientImpl(arrayFiller);

    }

}
