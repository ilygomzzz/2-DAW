package es.javierserrano.domain.model.book;

import es.javierserrano.domain.exception.BusinessException;

import java.util.Objects;

public final class Isbn {
    private final String value;

    public Isbn(String value) {
        if(value==null || value.isBlank()){
            throw new BusinessException("El isbn no puede estar vacio");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Isbn name)) return false;
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
