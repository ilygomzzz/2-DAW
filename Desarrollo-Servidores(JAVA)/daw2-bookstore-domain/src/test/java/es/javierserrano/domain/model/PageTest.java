package es.javierserrano.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PageTest {

    @Nested
    @DisplayName("Tests for DataValidation")
    class DataValidationTests {
        @Test
        @DisplayName("Data smaller than Page Size should return data")
        void testValidationDataSize() {
            List<Book> data = List.of(
                    new Book(
                            "978-3-16-148410-0",
                            "Título en Español",
                            "Title in English",
                            "Sinopsis en Español",
                            "Synopsis in English",
                            new BigDecimal("50.00"),
                            10.0,
                            "cover.jpg",
                            LocalDate.of(2023, 1, 1),
                            null,
                            null
                    )
            );

            int pageSize = 5;
            Page<Book> bookPage = new Page<>(data,1,pageSize, data.size());
            assertEquals(bookPage.data(), data);
        }
    }


}