package com.payment.wallet.gateway.config;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {

    private static final List<String> OPEN_ENDPOINTS = List.of(
            "/api/v1/auth/register",
            "/api/v1/auth/login");

    public Predicate<ServerHttpRequest> isSecured = request -> OPEN_ENDPOINTS.stream()
            .noneMatch(
                    uri -> request.getURI()
                            .getPath()
                            .contains(uri));
}
