package com.trendyol.endpoint.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @NotNull(message = "is required")
    @Size(min = 1,message = "can not be empty")
    @Column
    private String author;

    @NotNull(message = "is required")
    @Size(min = 1,message = "can not be empty")
    @Column
    private String title;


    @Override
    public String toString() {
        return "Book{" +
                "id=" + bookId +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
