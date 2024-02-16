package com.amirlearn.amirlearn.entities.site;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    @Id
    @GeneratedValue
    private long id;
    private String key;
    private String value;
}
