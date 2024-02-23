package com.example.test_relationship.domain.photo;

import com.example.test_relationship.domain.book.Book;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.tool.schema.spi.SchemaTruncator;
import org.yaml.snakeyaml.events.Event;

@Data
@NoArgsConstructor
@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long id;

    @Column(name = "url_small")
    private String urlSmall;

    @Column(name = "url_medium")
    private String urlMedium;

    @Column(name = "url_large")
    private String urlLarge;

    @Builder
    public Photo(Long id, String urlSmall, String urlMedium, String urlLarge) {
        this.id = id;
        this.urlSmall = urlSmall;
        this.urlMedium = urlMedium;
        this.urlLarge = urlLarge;
    }
}
