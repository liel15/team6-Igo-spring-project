package lx.team6.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // vue.js 주소

public class ImageUploadController {

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String folderPath = "C:/lx/team6-spring-project/frontend/public/images/";
        String fileName = file.getOriginalFilename();

        File saveFile = new File(folderPath + fileName);
        try {
            // 파일을 지정된 경로에 저장
            file.transferTo(saveFile);
            
            // 저장된 파일 경로를 반환 (DB에 저장할 경로)
            String imagePath = "/images/" + fileName;
            return ResponseEntity.ok(imagePath);  // 클라이언트로 이미지 경로 반환
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("File upload failed");
        }
    }
}
