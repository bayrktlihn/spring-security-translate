package io.bayrktlihn.springapp.service.impl;

import io.bayrktlihn.springapp.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TranslateServiceImpl implements TranslateService {
    private final MessageSource messageSource;


    @Override
    public String instant(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }


    @Override
    public String instant(String code, Object[] args, String defaultMessage) {
        return messageSource.getMessage(code, args, defaultMessage, LocaleContextHolder.getLocale());
    }


    @Override
    public String instant(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }


}
