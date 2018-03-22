package abc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class BaseMethods {

	public static User getCurrentUser() {

		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	}

}
