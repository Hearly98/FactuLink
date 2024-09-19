package com.factulink.fkb.api.controller;

import com.factulink.fkb.api.model.Document;
import com.factulink.fkb.api.model.Product;
import com.factulink.fkb.api.service.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
@AllArgsConstructor
public class DocumentController  {

    private final DocumentService documentService;

    @GetMapping()
    public ResponseEntity<Object> allDocuments(){
        return documentService.getDocuments();
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveDocument(@RequestBody Document document){
        return documentService.addDocuments(document);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDocumentById(@PathVariable("id") Integer id){
        return documentService.getDocumentById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateDocument(@PathVariable("id")Integer id, @RequestBody Document document){
        return documentService.updateDocument(document, id);
    }
}
