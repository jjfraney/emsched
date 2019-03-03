package org.jjfflyboy.em.scheduler.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author jfraney
 */
public class DeckTest {

    private static final Integer COUNT = 4;
    private List<Integer> original = IntStream.range(0, COUNT).boxed().collect(Collectors.toList());
    private Dealer<Integer> dealer;

    @Before
    public void before() {
        dealer = new Dealer<>(original);
    }
    @Test
    public void testNewDeckFeature() {
        Set<Integer> drawn = new HashSet<>();
        for(int i = 0; i < COUNT; i++) {
            Integer card = dealer.card();
            Assert.assertFalse("card should not have been seen before", drawn.contains(card));
            drawn.add(card);
        }
        Assert.assertEquals("should have drawn COUNT unique cards", (long) COUNT, drawn.size());

        Integer card = dealer.card();
        Assert.assertTrue("card should've already been seen before", drawn.contains(card));
    }

    @Test
    public void testDrawManyCards() {
        Integer count = COUNT * 3 + COUNT / 3;
        List<Integer> drawn = dealer.cards(count);
        Assert.assertEquals("should have drawn 'count' cards", (long)count, drawn.size());
    }
}
