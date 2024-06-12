package de.atruvia.application.time;

import java.time.Duration;

public interface Stopwatch {

    void start();
    void stop();
    Duration getDuration();
}
