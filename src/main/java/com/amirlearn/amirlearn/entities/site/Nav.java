package com.amirlearn.amirlearn.entities.site;

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
public class Nav {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String link;
    private boolean enable;
    private Integer orderItem;
}
