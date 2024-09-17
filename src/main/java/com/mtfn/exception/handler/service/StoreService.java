package com.mtfn.exception.handler.service;

import com.mtfn.exception.handler.domain.entity.Store;
import com.mtfn.exception.handler.exception.StoreNotFoundException;
import com.mtfn.exception.handler.domain.repository.StoreRepository;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;

@Service
@RequiredArgsConstructor
public class StoreService implements Serializable {

    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    //Since it was a simple example, there was no need to return dto
    public Store getStoreDetail(String storeCode) {
        return storeRepository.findByCode(storeCode).orElseThrow(() -> new StoreNotFoundException("Store not found"));
    }
}
