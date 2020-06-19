package ru.nsu.fit.g18213.tromenshleger;

import java.util.concurrent.Future;

class FutureRes {
    final Object object;
    final java.util.concurrent.Future<?> future;

    FutureRes(Object object, java.util.concurrent.Future<?> future) {
        this.object = object;
        this.future = future;
    }
}