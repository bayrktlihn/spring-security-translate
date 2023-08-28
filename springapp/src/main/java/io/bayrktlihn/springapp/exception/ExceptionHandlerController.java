package io.bayrktlihn.springapp.exception;

import io.bayrktlihn.springapp.dto.ResponseDto;
import io.bayrktlihn.springapp.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController {

    private final TranslateService translateService;


    @ExceptionHandler(I18nSupportedException.class)
    public ResponseEntity<?> handleI18nSupportedException(I18nSupportedException i18nSupportedException) {

        String message = translateService.instant(i18nSupportedException.getCode(), i18nSupportedException.getArgs(), i18nSupportedException.getDefaultMessage());

        ResponseDto<?> response = ResponseDto.createFail(message);

        return ResponseEntity.ok(response);

    }

}
