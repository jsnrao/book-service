package com.word.library.exception;

/*
 * Copyright © 2015 Sky plc All Rights reserved.
 * Please do not make your solution publicly available in any way e.g. post in forums or commit to GitHub.
 */

import com.word.library.common.BookErrorCode;
import com.word.library.common.ErrorMessage;
import lombok.*;

import java.util.Optional;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookNotFoundException extends RuntimeException {

    private BookErrorCode errorCode;
    private ErrorMessage errorMessage;
    private Object data;

    public BookNotFoundException(BookErrorCode errorCode, ErrorMessage errorMessage) {
        super(Optional.ofNullable(errorMessage).map(ErrorMessage::getMessageToFrontEnd).orElse(null));
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
