package controller.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import service.file.FileService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FileController {

	private FileService fileService; // FileService를 주입 받을 필요가 있습니다.

	// FileService를 주입받기 위한 생성자
	public FileController(FileService fileService) {
		this.fileService = fileService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String fileUpload(HttpServletRequest request, HttpServletResponse response) {
		// HttpServletRequest를 통해 MultipartFile을 가져옵니다.
		MultipartFile uploadFile = (MultipartFile) request.getAttribute("file");

		if (uploadFile != null && !uploadFile.isEmpty()) {
			fileService.fileUpload(request, response, uploadFile);
			return "redirect:/"; // 업로드 후 리다이렉트할 경로를 지정합니다.
		} else {
			return "errorPage";
		}
	}

	@RequestMapping(value = "/fileCheck", method = RequestMethod.GET)
	public String fileCheck() {
		return "file-check";
	}
}
