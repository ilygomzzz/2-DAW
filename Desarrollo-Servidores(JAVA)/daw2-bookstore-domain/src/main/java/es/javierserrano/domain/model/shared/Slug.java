package es.javierserrano.domain.model.shared;


import es.javierserrano.domain.exception.BusinessException;

import java.util.Objects;

public final class Slug {
    private final String value;

    public Slug(String value) {
        if (value == null || !value.matches("^[a-z0-9]+(?:-[a-z0-9]+)*$") || value.trim().isEmpty()) {
            throw new BusinessException("Slug inválido");
        }
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Slug slug)) return false;
        return value.equals(slug.value);
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