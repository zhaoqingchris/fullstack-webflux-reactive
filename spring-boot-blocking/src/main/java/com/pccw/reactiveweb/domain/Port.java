package com.pccw.reactiveweb.domain;

import java.util.Objects;
import java.util.StringJoiner;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Port {

    @Id
    private String id;
    private String name;
    private String location;

    // Empty constructor is needed for Jackson to deserialize JSON
    public Port() {
    }

    public Port(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Port.class.getSimpleName() + "[", "]")
            .add("id='" + id + "'")
            .add("name='" + name + "'")
            .add("location='" + location + "'")
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Port)) {
            return false;
        }
        Port port = (Port) o;
        return Objects.equals(getId(), port.getId()) &&
            Objects.equals(getName(), port.getName()) &&
            Objects.equals(getLocation(), port.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLocation());
    }
}
