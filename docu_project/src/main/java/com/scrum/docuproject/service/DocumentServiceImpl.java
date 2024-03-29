package com.scrum.docuproject.service;

import com.scrum.docuproject.models.FileDocument;
import com.scrum.docuproject.models.Versions;
import com.scrum.docuproject.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentRepository documentRepository;
//    @Autowired
//    VersionService versionService;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Optional<FileDocument> findDocument(String id) {
        return documentRepository.findById(id);
    }

    @Override
    public Optional<FileDocument> addDocument(Optional<FileDocument> document) {
        documentRepository.save(document);
        return document;
    }

    @Override
    public List<FileDocument> getAll() {
        List<FileDocument> fileDocumentList = documentRepository.findAll();
        return fileDocumentList;
    }

    @Override
    public Optional<FileDocument> getDocById(String id) {
        Optional<FileDocument> fileDocument = documentRepository.findById(id);
        return fileDocument;
    }


    @Override
    public void deteleById(String id) {
        documentRepository.deleteById(id);
    }

    @Override
    public FileDocument updateDocument(FileDocument fileDocument) {
        documentRepository.save(fileDocument);
        return fileDocument;
    }

    @Override
    public Optional <FileDocument> addFile(Optional<FileDocument> fileDocument, Versions versions) {
        if (fileDocument.isPresent()) {
            FileDocument actualDoc = fileDocument.get();
            List<Versions> versionsList = actualDoc.getVersions();
            if (versionsList == null) {
                versionsList = new ArrayList<>();

            }
//            versionService.addVersion(versions);
            versionsList.add(versions);
            actualDoc.setVersions(versionsList);
            documentRepository.save(actualDoc);
            return Optional.of(actualDoc);

        }
        return  fileDocument;


    }
}
