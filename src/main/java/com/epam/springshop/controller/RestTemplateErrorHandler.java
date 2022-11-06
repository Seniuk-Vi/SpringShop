package com.epam.springshop.controller;

import com.epam.springshop.exceptions.ProductNotFoundException;
import com.epam.springshop.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
@Slf4j
public class RestTemplateErrorHandler  implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse)

            throws IOException {
        log.info(this.getClass() + ": method ==> hasError");

        return (
                httpResponse.getStatusCode().series() == CLIENT_ERROR
                        || httpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response)
            throws IOException {
        log.info(this.getClass() + ": method ==> handleError");

        if (response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
            // handle 5xx errors
            // raw http status code e.g `500`
            System.out.println(response.getRawStatusCode());
            // http status code e.g. `500 INTERNAL_SERVER_ERROR`
            System.out.println(response.getStatusCode());
        } else if (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            // handle 4xx errors
            // raw http status code e.g `404`
            System.out.println(response.getRawStatusCode());

            // http status code e.g. `404 NOT_FOUND`
            System.out.println(response.getStatusCode());

            // get response body
            System.out.println(response.getBody());

            // get http headers
            HttpHeaders headers = response.getHeaders();
            System.out.println(headers.get("Content-Type"));
            System.out.println(headers.get("Server"));
        }
    }
}