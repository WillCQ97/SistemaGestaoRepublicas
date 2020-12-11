package model;

import java.util.Objects;

public class AbstractModel implements Comparable<Object> {

    protected int id;

    @Override
    public boolean equals(Object obj) {
        if ((obj == null || obj.getClass() != this.getClass()) ) {
            return false;
        }

        AbstractModel castedObject = (AbstractModel) obj;

        return castedObject.getId() == this.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return this.id;
    }

    @Override
    public int compareTo(Object o) {
        AbstractModel convertedObject = (AbstractModel) o;
        return this.getId() - convertedObject.getId();
    }
}
