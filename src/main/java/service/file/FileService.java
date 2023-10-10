package service.file;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {
	void fileUpload(HttpServletRequest request, HttpServletResponse response, MultipartFile uploadFile);

	void fileUpload(MultipartFile uploadFile);

}
