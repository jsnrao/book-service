package com.word.library.util;

import com.word.library.common.CommonConstant;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class BookUtil {

    public static String getTitleAppendedWithBook(String title) {
        return title + CommonConstant.BOOK;
    }

    public static String getTitleAppendedWithHiphen(String title) {
        return title + CommonConstant.HIPHEN;
    }

    public static String getBookReference(String bookReference) {
        return CommonConstant.OPEN_BRACKET + bookReference + CommonConstant.CLOSE_BRACKET;
    }

    public static String getBookReviewWithElipsis(String bookReview) {
        if (StringUtils.isNoneBlank(bookReview)) {
            String[] wordsArray = (bookReview.split(CommonConstant.REGEX_SPACE));
            if (wordsArray.length > CommonConstant.NINE) {
                wordsArray = ArrayUtils.subarray(wordsArray, CommonConstant.ZERO, CommonConstant.NINE);
                return StringUtils.join(wordsArray, CommonConstant.SPACE) + CommonConstant.ELIPSIS;
            }

        }
        return bookReview;
    }
}
