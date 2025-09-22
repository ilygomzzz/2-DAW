package es.javierserrano.domain.mapper;

import es.javierserrano.domain.exception.BusinessException;
import es.javierserrano.domain.model.Publisher;
import es.javierserrano.domain.repository.entity.PublisherEntity;
import es.javierserrano.domain.service.dto.PublisherDto;

public class PublisherMapper {
    private static PublisherMapper instance;

    private PublisherMapper() {}

    public static PublisherMapper getInstance() {
        if (instance == null) {
            instance = new PublisherMapper();
        }

        return instance;
    }

    public Publisher fromPublisherEntityToPublisher(PublisherEntity publisherEntity) {
        if (publisherEntity == null) {
            throw new BusinessException("PublisherEntity cannot be null");
        }

        return new Publisher(
                publisherEntity.name(),
                publisherEntity.slug()
        );
    }

    public PublisherEntity fromPublisherToPublisherEntity(Publisher publisher) {
        if (publisher == null) {
            throw new BusinessException("Publisher cannot be null");
        }

        return new PublisherEntity(
                publisher.getName(),
                publisher.getSlug()
        );
    }

    public PublisherDto fromPublisherToPublisherDto(Publisher publisher) {
        if (publisher == null) {
            throw new BusinessException("Publisher cannot be null");
        }
        return new PublisherDto(
                publisher.getName(),
                publisher.getSlug()
        );
    }

    public Publisher fromPublisherDtoToPublisher(PublisherDto publisherDto) {
        if (publisherDto == null) {
            throw new BusinessException("PublisherDto cannot be null");
        }
        return new Publisher(
                publisherDto.name(),
                publisherDto.slug()
        );
    }
}
