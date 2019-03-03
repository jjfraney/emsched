package org.jjfflyboy.em.scheduler.model;

import java.util.Objects;

/**
 * @author jfraney
 */
public class Minister {
    private String firstName;
    private String lastName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minister minister = (Minister) o;
        return Objects.equals(getFirstName(), minister.getFirstName()) &&
                Objects.equals(getLastName(), minister.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }
}
