package es.javierserrano.domain.model.shared;

import es.javierserrano.domain.exception.BusinessException;

import java.util.Objects;

public final class Name {
    private final String value;

    public Name(String value) {
        if(value == null || value.isBlank() || value.trim().isEmpty()){
            throw new BusinessException("El nombre no puede estar vacio");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Name name)) return false;
        return value.equals(name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
