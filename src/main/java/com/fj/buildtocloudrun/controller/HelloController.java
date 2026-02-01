package com.fj.buildtocloudrun.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

import java.util.Map;

@RestController
@OpenAPIDefinition(servers = {@Server(url = "/", description = "This is the Server URL")})
public class HelloController {

    @GetMapping("/hello")
    @Operation(summary = "Simple hello endpoint taking name as input")
    public ResponseEntity<Map<String, String>> getHello(
            @RequestParam(value = "name") String name) {
        return ResponseEntity.ok(Map.of("message", "Hello " + name));
    }
}
