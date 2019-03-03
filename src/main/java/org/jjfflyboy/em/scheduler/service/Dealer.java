package org.jjfflyboy.em.scheduler.service;

import org.jjfflyboy.em.scheduler.model.Minister;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

/**
 * @author jfraney
 */
class Dealer<T> {
    private List<T> input;
    private Deque<T> deck;

    public Dealer(List<T> input) {
        this.input = new ArrayList<>(input);
        this.deck = newDeck();
    }

    public List<T> cards(Integer count) {
        return range(0, count).mapToObj((i) -> card()).collect(Collectors.toList());
    }

    public T card() {
        if (deck.isEmpty()) {
            deck = newDeck();
        }
        return deck.poll();
    }

    private Deque<T> newDeck() {
        LinkedList<T> newDeck = new LinkedList<>(input);
        Collections.shuffle(newDeck);
        return newDeck;
    }
}
