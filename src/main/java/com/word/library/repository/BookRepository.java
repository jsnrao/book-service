package com.word.library.repository;

/*
 * Copyright © 2015 Sky plc All Rights reserved.
 * Please do not make your solution publicly available in any way e.g. post in forums or commit to GitHub.
 */

import com.word.library.exception.BookNotFoundException;


public interface BookRepository {
    String retrieveBook(String reference) throws BookNotFoundException;

    String getBookSummary(String bookReference);
}
