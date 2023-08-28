package io.bayrktlihn.springapp.exception;

import lombok.Getter;

@Getter
public abstract class I18nSupportedException extends RuntimeException {
    private final String code;
    private final Object[] args;
    private final String defaultMessage;


    public I18nSupportedException(String code, Object[] args, String defaultMessage) {
        this.code = code;
        this.args = args;
        this.defaultMessage = defaultMessage;
    }

    public I18nSupportedException(String code) {
        this.code = code;
        this.args = null;
        this.defaultMessage = null;
    }

    public I18nSupportedException(String code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
        this.args = null;
    }

    public I18nSupportedException(String code, Object[] args) {
        this.code = code;
        this.args = args;
        defaultMessage = null;
    }
}
