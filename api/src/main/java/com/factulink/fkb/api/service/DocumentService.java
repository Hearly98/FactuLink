package com.factulink.fkb.api.service;

import com.factulink.fkb.api.model.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface DocumentService {
    public ResponseEntity<Object> getDocuments();
    public ResponseEntity<Object> addDocuments(Document document);
    public ResponseEntity<Object> getDocumentById(Integer id);
    public ResponseEntity<Object> updateDocument(Document doc, Integer id);
}
