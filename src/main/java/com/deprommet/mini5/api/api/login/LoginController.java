package com.deprommet.mini5.api.api.login;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin("*")
public class LoginController {
	@PostMapping("/login")
	public String login(HttpServletResponse response, @RequestBody String nickname) {
		Cookie cookie = new Cookie("nickname",nickname);
		response.addCookie(cookie);
		return nickname;
	}
}
