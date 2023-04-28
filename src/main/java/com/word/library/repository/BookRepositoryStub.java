package com.word.library.repository;

/*
 * Copyright © 2015 Sky plc All Rights reserved.
 * Please do not make your solution publicly available in any way e.g. post in forums or commit to GitHub.
 */

import com.word.library.common.BookErrorCode;
import com.word.library.common.ErrorMessage;
import com.word.library.domain.Book;
import com.word.library.exception.BookNotFoundException;
import com.word.library.util.BookUtil;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class BookRepositoryStub implements BookRepository {
    private static final String BOOK_REFERENCE_PREFIX = "BOOK-";

    private static final String THE_GRUFFALO_REFERENCE = BOOK_REFERENCE_PREFIX + "GRUFF472";
    private static final String WINNIE_THE_POOH_REFERENCE = BOOK_REFERENCE_PREFIX + "POOH222";
    private static final String THE_WIND_IN_THE_WILLOWS_REFERENCE = BOOK_REFERENCE_PREFIX + "WILL987";

    private static final Map<String, Book> books;

    static {
        books = new HashMap<String, Book>();
        books.put(THE_GRUFFALO_REFERENCE, new Book(THE_GRUFFALO_REFERENCE, "The Gruffalo", "A mouse taking a walk in the woods."));
        books.put(WINNIE_THE_POOH_REFERENCE, new Book(WINNIE_THE_POOH_REFERENCE, "Winnie The Pooh", "In this first volume, we meet all the friends from the Hundred Acre Wood."));
        books.put(THE_WIND_IN_THE_WILLOWS_REFERENCE, new Book(THE_WIND_IN_THE_WILLOWS_REFERENCE, "The Wind In The Willows",
                "With the arrival of spring and fine weather outside, " +
                        "the good-natured Mole loses patience with spring cleaning. He flees his underground home, emerging to take in the air and ends up at the river, which he has " +
                        "never seen before. Here he meets Rat (a water vole), who at this time of year spends all his days in, on and close by the river. Rat takes Mole for a ride " +
                        "in his rowing boat. They get along well and spend many more days boating, with Rat teaching Mole the ways of the river."));
    }

    public String retrieveBook(String reference) throws BookNotFoundException {
        if (StringUtils.isNotBlank(reference) && Objects.nonNull(books.get(reference))) {
            return BookUtil.getTitleAppendedWithBook(books.get(reference).getTitle());
        } else throw new BookNotFoundException(BookErrorCode.DATA_NOT_FOUND_EXCEPTION, ErrorMessage.BOOK_NOT_FOUND_EXCEPTION);
    }

    @Override
    public String getBookSummary(String bookReference) throws BookNotFoundException {
        if (StringUtils.isNotBlank(bookReference) && Objects.nonNull(books.get(bookReference))) {
            Book book = books.get(bookReference);
            return BookUtil.getBookReference(bookReference) + BookUtil.getTitleAppendedWithHiphen(book.getTitle()) + BookUtil.getBookReviewWithElipsis(book.getReview());
        } else throw new BookNotFoundException(BookErrorCode.DATA_NOT_FOUND_EXCEPTION, ErrorMessage.BOOK_NOT_FOUND_EXCEPTION);
    }


}
