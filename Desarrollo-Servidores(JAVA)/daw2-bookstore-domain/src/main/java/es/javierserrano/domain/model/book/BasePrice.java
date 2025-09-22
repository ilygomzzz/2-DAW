package es.javierserrano.domain.model.book;

import es.javierserrano.domain.exception.BusinessException;

import java.math.BigDecimal;
import java.util.Objects;

public final class BasePrice {
    private final BigDecimal value;

    public BasePrice(BigDecimal value) {
        if(value==null || value.compareTo(BigDecimal.ZERO)<=0){
            throw new BusinessException("El precio base debe ser mayor que cero");
        }
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BasePrice price)) return false;
        return value.equals(price.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
