package service.file;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@Service
public abstract class FileServiceImpl implements FileService {

    public void fileUpload(HttpServletRequest request) {
        try {
            // HttpServletRequest에서 MultipartResolver를 통해 MultipartFile을 추출
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            if (multipartResolver.isMultipart(request)) {
                StandardMultipartHttpServletRequest multiRequest = (StandardMultipartHttpServletRequest) request;
                MultipartFile uploadFile = multiRequest.getFile("uploadFile");

                if (uploadFile != null && !uploadFile.isEmpty()) {
                    InputStream inputStream = uploadFile.getInputStream();
                    System.out.println("Content Type: " + uploadFile.getContentType());

                    boolean isValid = isValidImgFile(inputStream);
                    if (!isValid) {
                        // 이미지 파일이 아닌 경우 예외 처리
                        System.out.println("이미지 파일만 업로드 가능합니다.");
                    } else {
                        // 이미지 파일이 맞을 때 업로드 로직 수행
                        // 업로드 로직
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 이미지 파일 유효성 검사 메서드
    private boolean isValidImgFile(InputStream inputStream) {
        // 이미지 파일 유효성 검사 로직을 구현해야 합니다.
        // 허용되는 이미지 확장자나 기타 검사 로직을 여기에 추가하세요.
        // 이 코드는 예시일 뿐이며, 실제 검사 로직은 프로젝트 요구에 따라 다를 수 있습니다.
        return true; // 임시로 true를 반환합니다.
    }
}
