package com.example.documentFlow.requestArchivist.repository;

import com.example.documentFlow.requestArchivist.model.RequestArchivist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestArchivistRepository extends JpaRepository<RequestArchivist, Long> {


}
