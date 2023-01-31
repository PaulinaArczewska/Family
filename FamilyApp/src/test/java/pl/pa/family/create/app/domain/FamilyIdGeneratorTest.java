package pl.pa.family.create.app.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class FamilyIdGeneratorTest {

    @Test
    void random100Id() {
        //given
        Set<Integer> uniquesId = new HashSet<>();
        //when
        for (int i = 0; i < 100; i++) {
            int id = FamilyIdGenerator.next();
            uniquesId.add(id);
        }
        //then
        Assertions.assertEquals(100, uniquesId.size());
    }
}
