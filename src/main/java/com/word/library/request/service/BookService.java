package com.word.library.request.service;

/*
 * Copyright © 2015 Sky plc All Rights reserved.
 * Please do not make your solution publicly available in any way e.g. post in forums or commit to GitHub.
 */

import com.word.library.exception.BookNotFoundException;

public interface BookService {
    String retrieveBook(String bookReference) throws BookNotFoundException;
    String getBookSummary(String bookReference) throws BookNotFoundException;
}
