package com.example.documentFlow.requestArchivist.service;

import com.example.documentFlow.requestArchivist.model.RequestArchivist;

import java.util.List;

public interface RequestArchivistService {

    List<RequestArchivist> getRequests();

    RequestArchivist getRequest(Long requestId);

    RequestArchivist save(RequestArchivist requestArchivist);

}
