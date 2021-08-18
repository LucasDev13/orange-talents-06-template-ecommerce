package br.com.ecommerce.mercadolivre.config.security.filter;

import br.com.ecommerce.mercadolivre.config.token.GenerateToken;
import br.com.ecommerce.mercadolivre.model.User;
import br.com.ecommerce.mercadolivre.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationViaTokenFilter extends OncePerRequestFilter {

    private GenerateToken generateToken;
    private UserRepository userRepository;

    public AuthenticationViaTokenFilter(GenerateToken generateToken, UserRepository userRepository) {
        this.generateToken = generateToken;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = retrieveToken(httpServletRequest);
        boolean valid = generateToken.isTokenValid(token);
        if(valid){
            authenticateClient(token);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String retrieveToken(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7, token.length());
    }

    private void authenticateClient(String token){
        Long idUser = generateToken.getIdUser(token);
        User user = userRepository.findById(idUser).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
