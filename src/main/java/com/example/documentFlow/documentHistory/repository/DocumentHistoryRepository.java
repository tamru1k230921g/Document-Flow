package com.example.documentFlow.documentHistory.repository;

import com.example.documentFlow.documentHistory.model.DocumentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//
public interface DocumentHistoryRepository extends JpaRepository<DocumentHistory,Long> {

    List<DocumentHistory> findAllByDocumentId(Long documentId);

}
