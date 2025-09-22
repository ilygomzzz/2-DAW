package es.javierserrano.domain.model;

import es.javierserrano.domain.model.shared.Name;
import es.javierserrano.domain.model.shared.Slug;

public class Publisher {
    private Name name;
    private Slug slug;

    public Publisher(Name name, Slug slug) {
        this.name = name;
        this.slug = slug;
    }

    public String getName() {
        return name.toString();
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getSlug() {
        return slug.toString();
    }

    public void setSlug(Slug slug) {
        this.slug = slug;
    }
}

