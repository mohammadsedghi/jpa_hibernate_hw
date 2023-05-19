package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.base.entity.BaseEntity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Film extends BaseEntity<Long> {
    @Column(nullable = false)
    private String title;
    private String description;
    private String language;
    @ManyToOne
    @Column(name = "director_id",nullable = false)
    private Director director;
    private int rate;
    private int length;

}
