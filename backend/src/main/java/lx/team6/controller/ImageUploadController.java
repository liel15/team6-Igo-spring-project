package lx.team6.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageUploadController {

    private static final String UPLOAD_DIR = "C:/lx/team6-spring-project/frontend/public/images/";

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        try {
            // 파일 저장 경로 설정
            Path filePath = Paths.get(UPLOAD_DIR + file.getOriginalFilename());

            // 파일 저장
            Files.write(filePath, file.getBytes());

            // 성공 메시지 반환
            return ResponseEntity.ok("이미지가 성공적으로 저장되었습니다: " + file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파일 업로드 실패");
        }
    }
}
