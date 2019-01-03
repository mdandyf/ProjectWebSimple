package com.example.mitrais.ProjectWebSimple.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class FileUploadController {
    private static final String LOCATION = "C:\\Users\\Dandy_F122\\Downloads\\ProjectWebSimple\\ProjectWebSimple\\src\\main\\resources\\fileUpload\\";
    private String name;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("file")MultipartFile file) throws IOException {
        setName(file.getOriginalFilename());

        /* Save file into the temporary location */
        String pathName = LOCATION;
        File convertFile = new File(pathName);
        if(!convertFile.exists()) {
            try {
                convertFile.mkdir();
                System.out.println("new directory " + pathName + " has been created");
                convertFile = new File(pathName + getName());
                convertFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                return "File upload failed";
            }
        }

        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return "File has been uploaded";
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Object> fileDownload() throws IOException {
       /* Read the file from temporary location again */
        String fileName = LOCATION + getName();
        File file = new File(fileName);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity.ok().headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/txt")).body(resource);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
