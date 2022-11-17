package hello.typeconverter.controller;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormatterController {

	@GetMapping("/fomatter/edit")
	public String formatterForm(Model model) {
		Form form = new Form();
		form.setNumber(10000);
		form.setLocalDateTime(LocalDateTime.now());
		model.addAttribute("form", form);
		return "formatter-form";
	}


	@PostMapping("/formatter/edit")
	public String formmaterEdit(@ModelAttribute Form form) { // 어노테이션으로 자동으로 Model.addAttribute되기때문에 Model 생략.
		return "formatter-view";
	}

	@Data
	static class Form {

		@NumberFormat(pattern = "###,###")
		private Integer number;

		@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private LocalDateTime localDateTime;
	}
}
