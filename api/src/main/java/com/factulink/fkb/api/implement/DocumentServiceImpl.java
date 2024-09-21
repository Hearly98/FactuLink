package com.factulink.fkb.api.implement;

import com.factulink.fkb.api.model.Document;
import com.factulink.fkb.api.repository.DocumentRepository;
import com.factulink.fkb.api.service.DocumentService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private DocumentRepository dao;
    @Override
    public ResponseEntity<Object> getDocuments(){
        List<Document> documents = dao.findAll();
        if(!documents.isEmpty()){
            return new ResponseEntity<>(documents, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No existen registros", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Object> addDocuments(Document document) {
       Document saveDocument = dao.save(document);
       return new ResponseEntity<>(saveDocument, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getDocumentById(Integer id) {
       Optional<Document> document = dao.findById(id);
       if(document.isPresent()){
           return new ResponseEntity<>(document.get(), HttpStatus.OK);
       }else{
           return new ResponseEntity<>("El id no ha sido encontrado", HttpStatus.NOT_FOUND);
       }
    }

    @Override
    public ResponseEntity<Object> updateDocument(Document doc, Integer id) {
        Optional<Document> documentExist = dao.findById(id);
        if(documentExist.isPresent()){
            Document document = documentExist.get();
            document.setName(doc.getName());
            document.setDescription(doc.getDescription());
            dao.save(document);
            return new ResponseEntity<>("Datos del documento modificado", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Sin registros con ID:" + id, HttpStatus.NOT_FOUND);
        }
    }
}
