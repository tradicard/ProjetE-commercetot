package com.intiFormation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.Config.AuthentificationRequest;
import com.intiFormation.Config.AuthentificationResponse;
import com.intiFormation.Config.jwtUtil;
import com.intiFormation.Service.CustemUserDetailsService2;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TestController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private CustemUserDetailsService2 custemUserDetailsService;
	
	
	@Autowired
	private jwtUtil jwtokenUtil;
	
	@GetMapping("/test22")
	public String test22()
	{
		return "Bonjour";
	}
	
	@RequestMapping(value="/authenticate" ,method =RequestMethod.POST)
	public ResponseEntity<?> authenticate(@RequestBody AuthentificationRequest authentificationRequest) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentificationRequest.getUsername(), authentificationRequest.getPassword()));
			
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("incorrect username ou password",e);
		}
		
		final UserDetails userdetails=custemUserDetailsService.loadUserByUsername(authentificationRequest.getUsername());
		final String jwt=jwtokenUtil.generateToken(userdetails);
		
		
		return new ResponseEntity(new AuthentificationResponse(jwt), HttpStatus.OK);
	}

}
