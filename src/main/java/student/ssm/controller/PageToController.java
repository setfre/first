package student.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pageTo")
public class PageToController {

	@RequestMapping("personInfo")
	public String toPersonInfo() {
		return "jsp/personInfo";
	}
}
