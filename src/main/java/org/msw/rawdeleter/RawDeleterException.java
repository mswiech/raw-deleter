package org.msw.rawdeleter;

/**
 * Created by Martin Swiech on 17.4.2016.
 */
public class RawDeleterException extends RuntimeException {

    public RawDeleterException() {
        super();
    }

    public RawDeleterException(final String message) {
        super(message);
    }

    public RawDeleterException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RawDeleterException(final Throwable cause) {
        super(cause);
    }

    public RawDeleterException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
