package com.example.continent_explorer.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoggingFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;


        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            System.out.println("Filter Exception: " + e.getMessage());
        }

        System.out.println("Response Status: " + httpServletResponse.getStatus());
    }

}
