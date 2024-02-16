package com.amirlearn.amirlearn.entities.videos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize = 1)
    private long id;
    private String title;
    private String link;
    private String image;
    private Integer orderItem;
    @OneToMany
    private List<Video> videos;
    private boolean enable;
}
