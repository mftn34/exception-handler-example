package com.mtfn.exception.handler.controller;

import com.mtfn.exception.handler.data.RestResponseGenerator;
import com.mtfn.exception.handler.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/stores", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
public class StoreController {

    private final RestResponseGenerator restResponseGenerator;

    private final StoreService storeService;

    @GetMapping("/detail")
    public ResponseEntity<Object> storeDetail(@RequestParam String storeCode) {
        return restResponseGenerator.success(storeService.getStoreDetail(storeCode));
    }
}
