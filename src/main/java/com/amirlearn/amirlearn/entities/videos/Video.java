package com.amirlearn.amirlearn.entities.videos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "video_seq")
    @SequenceGenerator(name = "video_seq", sequenceName = "video_seq", allocationSize = 1)
    private long id;
    private String title;
    private String description;
    private String image;
    private String url;
    private Long visitCount;
    private Date publishDate;
    private boolean enable;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
