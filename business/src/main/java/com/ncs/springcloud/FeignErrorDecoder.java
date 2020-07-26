package com.ncs.springcloud;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import java.io.IOException;

@Configuration
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            String message = Util.toString(response.body().asReader());

            ObjectMapper objectMapper = new ObjectMapper();
            OAuth2Exception oAuth2Exception = objectMapper.readValue(message, OAuth2Exception.class);
            return oAuth2Exception;
        } catch (IOException ignored) {
        }

        return decode(methodKey, response);
    }
}
