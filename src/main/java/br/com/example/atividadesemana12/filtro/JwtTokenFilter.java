package br.com.example.atividadesemana12.filtro;

import br.com.example.atividadesemana12.filtro.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@AllArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final AuthenticationManager authenticationManager;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
                                    throws ServletException, IOException {
        try {
            String jwtToken = extractJwtToken(request.getHeader("Authorization"));
            if (jwtToken != null && JwtUtil.validateToken(jwtToken)) {
                String username = JwtUtil.getUsernameFromToken(jwtToken);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(authenticationToken));
            }
        }
        catch (Exception e) {
            logger.error("Erro ao processar o token JWT: " + e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
    private String extractJwtToken(String header) {
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }


}
