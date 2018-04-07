package com.deprommet.mini5.api.api.login;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Deprecated
@RestController
@CrossOrigin("*")
public class LoginController {
	@Deprecated
	@PostMapping("/login")
	public String login(HttpServletResponse response, @RequestBody NickNameDto nickNameDto) {
		Cookie cookie = new Cookie("nickname", nickNameDto.getNickname());
		response.addCookie(cookie);
		return nickNameDto.getNickname();
	}

	private static class NickNameDto {
		private String nickname;

		public NickNameDto() {
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
	}
}
