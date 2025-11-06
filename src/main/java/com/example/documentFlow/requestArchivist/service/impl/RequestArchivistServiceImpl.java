package com.example.documentFlow.requestArchivist.service.impl;

import com.example.documentFlow.requestArchivist.model.RequestArchivist;
import com.example.documentFlow.requestArchivist.repository.RequestArchivistRepository;
import com.example.documentFlow.requestArchivist.service.RequestArchivistService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RequestArchivistServiceImpl implements RequestArchivistService {

    RequestArchivistRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<RequestArchivist> getRequests() {

        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public RequestArchivist getRequest(Long requestId) {
        return repository.findById(requestId)
                .orElseThrow(() ->
                        new RuntimeException("Запрос с id: " + requestId + " не найден"));

    }

    @Override
    @Transactional
    public RequestArchivist save(RequestArchivist requestArchivist) {

        return repository.save(requestArchivist);
    }
}
