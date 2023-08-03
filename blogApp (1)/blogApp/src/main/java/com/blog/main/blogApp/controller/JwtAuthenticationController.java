package com.blog.main.blogApp.controller;

import com.blog.main.blogApp.RequestResponse.JwtAuthRequest;
import com.blog.main.blogApp.RequestResponse.JwtAuthResponse;
import com.blog.main.blogApp.helper.JwtTokenHelper;
import com.blog.main.blogApp.services.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate/")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenHelper jwtTokenUHelper;

    @Autowired
    private UserDetailService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createAuthenticationToken(@RequestBody JwtAuthRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());

         UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUserName());

        String token = jwtTokenUHelper.generateToken(userDetails);

        JwtAuthResponse jwtAuthRequest = new JwtAuthResponse(token);

        return new ResponseEntity<JwtAuthResponse>(jwtAuthRequest, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
