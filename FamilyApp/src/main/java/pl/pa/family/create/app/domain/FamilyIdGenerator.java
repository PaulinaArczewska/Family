package pl.pa.family.create.app.domain;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class FamilyIdGenerator {

    static int next() {
        return (new Random().nextInt(Integer.MAX_VALUE));
    }
}
