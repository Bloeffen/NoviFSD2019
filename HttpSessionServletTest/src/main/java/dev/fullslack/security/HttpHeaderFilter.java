package dev.fullslack.security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class HttpHeaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws ServletException, IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Content-Security-Policy", "default-src 'self'; script-src 'self' 'unsafe-inline'; style-src 'self' 'unsafe-inline'; img-src 'self' data: https://www.w3.com; object-src 'none'; form-action 'self'");
        httpServletResponse.setHeader("Referrer-Policy", "no-referrer");
        httpServletResponse.setHeader("Feature-Policy", "camera 'none'");

        chain.doFilter(request, response);
    }
}
