package com.word.library.common;

public enum ErrorMessage {

    BOOK_NOT_FOUND_EXCEPTION(1000, BookErrorCode.DATA_NOT_FOUND_EXCEPTION, "BookNotFoundException"),
    BAD_PREFIX_EXCEPTION(1001, BookErrorCode.BAD_PREFIX_EXCEPTION, "Exception, informing the client that book reference must begin with BOOK-");

    private final int id;
    private final BookErrorCode errorCode;
    private final String messageToFrontEnd;

    ErrorMessage(int id, BookErrorCode errorCode, String messageToFrontEnd) {
        this.id = id;
        this.errorCode = errorCode;
        this.messageToFrontEnd = messageToFrontEnd;
    }

    public int getId() {
        return id;
    }

    public BookErrorCode getErrorCode() {
        return errorCode;
    }

    public String getMessageToFrontEnd() {
        return messageToFrontEnd;
    }
}
