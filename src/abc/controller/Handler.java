package abc.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class Handler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {


		/*User authUser = (User) SecurityContextHolder.getContext().getAuthentication();
		 session.setAttribute("uname", authUser.getUsername());  
	        session.setAttribute("authorities", authentication.getAuthorities());*/
			System.out.println("poiuytre");
	        String targetUrl = determineTarget(authentication); 
	        redirectStrategy.sendRedirect(request, response, targetUrl);
		
	}

	private String determineTarget(Authentication authentication) {
		// TODO Auto-generated method stub
		 Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		 System.out.println(authentication.getCredentials());
		 System.out.println(authentication.getName());
		 
		 String uname=authentication.getName();
		 System.out.println(authorities);
		 
	        if (authorities.contains("ROLE_ADMIN")) {
	        	System.out.println(this);
	        	return "/admin.htm?msg="+"";
	        } 
	        else if (authorities.contains("ROLE_USER")) {
				System.out.println("poiuyt");
	        	return "/user.htm?username="+uname;
	        }
	        else if (authorities.contains("ROLE_SUPERADMIN")) {
				System.out.println("in super");
	        	return "/indexsadmin.htm";
	        }
	        	       
		else {
            throw new IllegalStateException();
        }
    }

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
}
