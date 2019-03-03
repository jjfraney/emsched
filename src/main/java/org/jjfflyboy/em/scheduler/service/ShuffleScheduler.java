package org.jjfflyboy.em.scheduler.service;

import org.jjfflyboy.em.scheduler.model.Mass;
import org.jjfflyboy.em.scheduler.model.Minister;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jfraney
 */
public class ShuffleScheduler implements Scheduler<Minister> {
    @Override
    public Map<Mass, List<Minister>> assign(List<Minister> ministers, List<Mass> masses) {

        Dealer<Minister> dealer = new Dealer<>(ministers);

        return masses.stream()
                .map((m) -> new Tuple(m, dealer.cards(m.getNumberOfMinistersRequested())))
                .collect(Collectors.toMap(Tuple::mass, Tuple::ministers));
    }
    private class Tuple {
        private final Mass mass;
        private final List<Minister> ministers;
        Tuple(Mass left, List<Minister> ministers) {
            this.mass = left;
            this.ministers = ministers;
        }
        public Mass mass() {
            return mass;
        }
        public List<Minister> ministers() {
            return ministers;
        }
    }

}
