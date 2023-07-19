package com.sub.authen.controller;

import com.sub.authen.exception.AccountPermanentLockException;
import com.sub.authen.facade.FacadeService;
import com.sub.authen.request.AuthUserLoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final FacadeService authFacadeService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthUserLoginRequest request) {
        return ResponseEntity.ok(authFacadeService.login(request));
    }
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        throw new AccountPermanentLockException("1", 2L);
//        return null;
    }
}
