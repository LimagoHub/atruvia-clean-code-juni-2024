package de.atruvia.application.collection.inner.decorator;

import de.atruvia.application.collection.IntArrayFiller;
import de.atruvia.application.time.Stopwatch;
import de.atruvia.application.time.inner.StopwatchImpl;

public class IntArrayFillerBenchmarkDecorator implements IntArrayFiller {

    private final Stopwatch stopwatch = new StopwatchImpl();
    private final IntArrayFiller intArrayFiller;;

    public IntArrayFillerBenchmarkDecorator(IntArrayFiller intArrayFiller) {
        this.intArrayFiller = intArrayFiller;
    }

    @Override
    public int[] fillArray(final int[] arrayToFill) {
        stopwatch.start();
        final int[] result =  intArrayFiller.fillArray(arrayToFill);
        stopwatch.stop();
        System.out.println("Duration = " + stopwatch.getDuration().toMillis() + " millis");
        return result;
    }
}
