package io.bayrktlihn.springapp.exception;

public class UserNotFoundException extends I18nSupportedException{
    public UserNotFoundException(String code, Object[] args, String defaultMessage) {
        super(code, args, defaultMessage);
    }

    public UserNotFoundException(String code) {
        super(code);
    }

    public UserNotFoundException(String code, String defaultMessage) {
        super(code, defaultMessage);
    }

    public UserNotFoundException(String code, Object[] args) {
        super(code, args);
    }
}
