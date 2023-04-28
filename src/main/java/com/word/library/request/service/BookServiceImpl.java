package com.word.library.request.service;

/*
 * Copyright © 2015 Sky plc All Rights reserved.
 * Please do not make your solution publicly available in any way e.g. post in forums or commit to GitHub.
 */

import com.word.library.common.CommonConstant;
import com.word.library.common.BookErrorCode;
import com.word.library.common.ErrorMessage;
import com.word.library.exception.BookNotFoundException;
import com.word.library.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String retrieveBook(String bookReference) throws BookNotFoundException {
        if (bookReference.startsWith(CommonConstant.BOOK_PREFIX)) {
            return bookRepository.retrieveBook(bookReference);
        } else throw new BookNotFoundException(BookErrorCode.BAD_PREFIX_EXCEPTION, ErrorMessage.BAD_PREFIX_EXCEPTION);
    }

    public String getBookSummary(String bookReference) {
        if (bookReference.startsWith(CommonConstant.BOOK_PREFIX)) {
            return bookRepository.getBookSummary(bookReference);
        } else throw new BookNotFoundException(BookErrorCode.BAD_PREFIX_EXCEPTION, ErrorMessage.BAD_PREFIX_EXCEPTION);
    }
}
