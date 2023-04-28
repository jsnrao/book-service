package com.word.library.domain;

import lombok.*;

/*
 * Copyright © 2015 Sky plc All Rights reserved.
 * Please do not make your solution publicly available in any way e.g. post in forums or commit to GitHub.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String reference;
    private String title;
    private String review;
}
