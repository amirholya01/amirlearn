package com.amirlearn.amirlearn.entities.site;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slider {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String link;
    private String image;
    private String description;
    @Column(name = "order_item")
    private Integer orderItem;
    private boolean enable;
}
