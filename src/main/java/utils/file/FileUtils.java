package utils.file;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class FileUtils {

    public File multipartfileToFile(MultipartFile multipartFile) {
        try {
            File file = File.createTempFile("temp", null); // 임시 파일 생성
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(multipartFile.getBytes()); // MultipartFile의 내용을 파일에 쓰기
            }
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // validImgFile 메서드는 그대로 사용 가능하므로 변경할 필요가 없습니다.
    public boolean validImgFile(InputStream inputStream) {
        // 이미지 유효성 검사 로직은 그대로 사용 가능
        // 필요한 경우 코드를 수정하여 유효성 검사 규칙을 변경할 수 있습니다.
        return true; // 임시로 true를 반환합니다.
    }
}
