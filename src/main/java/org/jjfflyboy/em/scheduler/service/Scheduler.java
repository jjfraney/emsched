package org.jjfflyboy.em.scheduler.service;

import org.jjfflyboy.em.scheduler.model.Mass;
import org.jjfflyboy.em.scheduler.model.Minister;

import java.util.List;
import java.util.Map;

/**
 * @author jfraney
 */
public interface Scheduler<T> {
    /**
     * return a list of ministers assigned to each mass
     * @return
     */
    Map<Mass, List<T>> assign(List<T> ministers, List<Mass> masses);
}
