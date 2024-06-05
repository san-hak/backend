package com.mda.imirror.config.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthKey {
    @Value("${mirror.token}")
    String token;
}
