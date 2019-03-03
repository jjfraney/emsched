package org.jjfflyboy.em.scheduler.model;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * @author jfraney
 */
public class Mass {
    private ZonedDateTime dateTime;
    private Integer numberOfMinistersRequested;

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getNumberOfMinistersRequested() {
        return numberOfMinistersRequested;
    }

    public void setNumberOfMinistersRequested(Integer numberOfMinistersRequested) {
        this.numberOfMinistersRequested = numberOfMinistersRequested;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mass mass = (Mass) o;
        return Objects.equals(getDateTime(), mass.getDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateTime());
    }
}
