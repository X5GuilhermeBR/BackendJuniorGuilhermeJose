package br.com.employee.system.api.domain.pojos;

import br.com.employee.system.api.domain.enums.ErrorType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetValidationPojo {

    @JsonProperty("codigo")
    private final int code;

    @JsonProperty("mensagem")
    private final String message;

    public GetValidationPojo(final ErrorType type) {
        code = type.getCode();
        message = type.getMessage();
    }

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return this.code;
    }
}
