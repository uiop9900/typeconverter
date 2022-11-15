package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import javax.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConverterController {

	@GetMapping("/converter-view")
	public String converterView(Model model) {
		model.addAttribute("number", 10000);
		model.addAttribute("ipPort", new IpPort("127.0.0.1", 8080));
		return "converter-view";
	}

	@GetMapping("converter/edit")
	public String converterForm(Model model) {
		final IpPort ipPort = new IpPort("127.0.0.1", 8080);
		final Form form = new Form(ipPort);
		model.addAttribute("form", form);
		return "converter-form";
	}

	@PostMapping("/converter/edit")
	public String converterEdit(@ModelAttribute Form form, Model model) {
		final IpPort ipPort = form.getIpPort();
		model.addAttribute("IpPort", ipPort);
		return "converter-view";
	}

	@Data
	static class Form {
		private IpPort ipPort;

		public Form(final IpPort ipPort) {
			this.ipPort = ipPort;
		}
	}
}
