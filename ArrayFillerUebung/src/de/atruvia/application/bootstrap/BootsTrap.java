package de.atruvia.application.bootstrap;

import de.atruvia.application.client.Client;
import de.atruvia.application.client.inner.ClientImpl;
import de.atruvia.application.collection.IntArrayFiller;
import de.atruvia.application.collection.inner.decorator.IntArrayFillerBenchmarkDecorator;
import de.atruvia.application.collection.inner.parallel.IntArrayFillerParallelImpl;
import de.atruvia.application.collection.inner.sequential.IntArrayFillerSequentialImpl;
import de.atruvia.application.generator.IntGenerator;
import de.atruvia.application.generator.IntGeneratorBuilder;
import de.atruvia.application.generator.inner.random.RandomGeneratorBuilderImpl;
import de.atruvia.application.generator.inner.random.RandomNumberGenerator;

public class BootsTrap {

    public void startApplication() {
        for (int treadCount = 1; treadCount <= Runtime.getRuntime().availableProcessors() + 1; treadCount++) {
            run(treadCount);
        }
    }

    private void run(final int treadCount) {

        System.out.print("Running with " + treadCount + " threads...");

        IntGeneratorBuilder generatorBuilder = createIntGeneratorBuilder();
        IntArrayFiller arrayFiller = createIntFiller(generatorBuilder, treadCount);
        Client client = createClient(arrayFiller);
        client.doSomethingWithLargeArray();

    }

    private static IntGeneratorBuilder createIntGeneratorBuilder() {
        return new RandomGeneratorBuilderImpl();
    }

    private static IntArrayFiller createIntFiller(IntGeneratorBuilder generatorBuilder, final int treadCount) {
        IntArrayFiller result;
        if(treadCount == 1)
            result = new IntArrayFillerSequentialImpl(generatorBuilder.create());
        else
            result = new IntArrayFillerParallelImpl(treadCount, generatorBuilder);
        result = new IntArrayFillerBenchmarkDecorator(result);
        return result;
    }

    private static Client createClient(IntArrayFiller arrayFiller) {
        return new ClientImpl(arrayFiller);

    }

}
