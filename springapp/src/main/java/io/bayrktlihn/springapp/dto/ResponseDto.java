package io.bayrktlihn.springapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto<T> {

    private List<String> errorMessages;
    private boolean success;
    private T data;


    public static <T> ResponseDto<T> createFail(String... errorMessages) {
        List<String> errorMessageList = Arrays.stream(errorMessages).toList();
        ResponseDto<T> response = new ResponseDto<>();
        response.setData(null);
        response.setSuccess(false);
        response.setErrorMessages(errorMessageList);
        return response;
    }
}
