package br.com.employee.system.api.infrastructure.helpers;

import org.springframework.http.HttpStatus;

public final class HttpHelper {

    private HttpHelper() {
        super();
    }

    public static HttpStatus convertToHttpStatus(final int status) {
        final String strStatus = Integer.toString(status);
        final int httpStatus = Integer.parseInt(strStatus.substring(0, 3));
        return HttpStatus.valueOf(httpStatus);
    }
}