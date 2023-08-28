package io.bayrktlihn.springapp.service;

public interface TranslateService {
    String instant(String code, Object[] args);

    String instant(String code, Object[] args, String defaultMessage);

    String instant(String code);
}
