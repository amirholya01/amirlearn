package com.amirlearn.amirlearn.entities.site;

import com.amirlearn.amirlearn.enums.BlogStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;
    private String image;
    private Date publishDate;
    private BlogStatus status;
}
