package es.javierserrano.domain.mapper;

import es.javierserrano.domain.exception.BusinessException;
import es.javierserrano.domain.model.Book;
import es.javierserrano.domain.repository.entity.BookEntity;
import es.javierserrano.domain.service.dto.BookDto;

public class BookMapper {
    private static BookMapper instance;

    private BookMapper() {}

    public static BookMapper getInstance() {
        if (instance == null) {
            instance = new BookMapper();
        }

        return instance;
    }

    public Book fromBookEntityToBook(BookEntity bookEntity) {
        if (bookEntity == null) {
            throw new BusinessException("BookEntity cannot be null");
        }

        return new Book(
                bookEntity.isbn(),
                bookEntity.titleEs(),
                bookEntity.titleEn(),
                bookEntity.synopsisEs(),
                bookEntity.synopsisEn(),
                bookEntity.basePrice(),
                bookEntity.discountPercentage(),
                bookEntity.cover(),
                bookEntity.publicationDate(),
                PublisherMapper.getInstance().fromPublisherEntityToPublisher(bookEntity.publisher()),
                bookEntity.authors().stream().map(AuthorMapper.getInstance()::fromAuthorEntityToAuthor).toList()
        );
    }

    public BookEntity fromBookToBookEntity(Book book) {
        if (book == null) {
            throw new BusinessException("Book cannot be null");
        }

        return new BookEntity(
                book.getIsbn(),
                book.getTitleEs(),
                book.getTitleEn(),
                book.getSynopsisEs(),
                book.getSynopsisEn(),
                book.getBasePrice(),
                book.getDiscountPercentage(),
                book.getCover(),
                book.getPublicationDate(),
                PublisherMapper.getInstance().fromPublisherToPublisherEntity(book.getPublisher()),
                book.getAuthors().stream().map(AuthorMapper.getInstance()::fromAuthorToAuthorEntity).toList()
        );
    }

    public BookDto fromBookToBookDto(Book book) {
        if (book == null) {
            throw new BusinessException("Book cannot be null");
        }

        return new BookDto(
                book.getIsbn(),
                book.getTitleEs(),
                book.getTitleEn(),
                book.getSynopsisEs(),
                book.getSynopsisEn(),
                book.getBasePrice(),
                book.getDiscountPercentage(),
                book.calculateFinalPrice(),
                book.getCover(),
                book.getPublicationDate(),
                PublisherMapper.getInstance().fromPublisherToPublisherDto(book.getPublisher()),
                book.getAuthors().stream().map(AuthorMapper.getInstance()::fromAuthorToAuthorDto).toList()
        );
    }

    public Book fromBookDtoToBook(BookDto bookDto) {
        if (bookDto == null) {
            throw new BusinessException("BookDto cannot be null");
        }
        return new Book(
                bookDto.isbn(),
                bookDto.titleEs(),
                bookDto.titleEn(),
                bookDto.synopsisEs(),
                bookDto.synopsisEn(),
                bookDto.basePrice(),
                bookDto.discountPercentage(),
                bookDto.cover(),
                bookDto.publicationDate(),
                PublisherMapper.getInstance().fromPublisherDtoToPublisher(bookDto.publisher()),
                bookDto.authors().stream().map(AuthorMapper.getInstance()::fromAuthorDtoToAuthor).toList()
        );
    }
}
