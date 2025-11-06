package com.example.documentFlow.document.repository;

import com.example.documentFlow.document.model.Document;
import com.example.documentFlow.document.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document,Long> {

    Optional<List<Document>> findAllDocumentByOwnerIdAndStatus(Long employeeId, Status status);

    Optional<Document> findOneByIdAndOwnerIdAndStatus(Long documentId, Long employeeId, Status status);

    Optional<Document> findOneByIdAndStatus(Long documentId, Status status);
}
