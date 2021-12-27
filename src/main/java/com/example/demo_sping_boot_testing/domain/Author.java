package com.example.demo_sping_boot_testing.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "author")
public class Author {

    @Id
    private String authorId;
    private String authorName;
    private int authorAge;
    private String authorAddress;
}
