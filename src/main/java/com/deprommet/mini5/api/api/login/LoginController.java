package com.deprommet.mini5.api.api.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {
	@PostMapping("/login")
	public String login(HttpServletResponse response,@RequestBody String nickname) {
		Cookie cookie = new Cookie("nickname",nickname);

		response.addCookie(cookie);
		
		return nickname;
		
	}
}
