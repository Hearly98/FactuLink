package com.factulink.fkb.api.repository;

import com.factulink.fkb.api.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
