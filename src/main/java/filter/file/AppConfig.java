package filter.file;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AppConfig {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile uploadFile, Model model) {
        // 파일 업로드 및 로직 처리
        // FileService를 호출하거나 업로드된 파일을 다룰 수 있습니다.

        // 결과를 모델에 추가
        model.addAttribute("message", "파일 업로드 성공!");
        return "result";
    }

    @RequestMapping(value = "/fileCheck", method = RequestMethod.GET)
    public String fileCheck() {
        return "file-check";
    }
}

