package cn.com.chinahitech.bjmarket.interceptor;



import cn.com.chinahitech.bjmarket.utils.JwtUtils;
import io.jsonwebtoken.Claims;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtRoleInterceptor implements HandlerInterceptor {
    private final String requiredRole;

    public JwtRoleInterceptor(String requiredRole) {
        this.requiredRole = requiredRole;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("401 Unauthorized - Missing token");
            return false;
        }

        try {
            String token = authHeader.substring(7);
            Claims claims = JwtUtils.parseToken(token);
            String role = claims.get("role", String.class);

            if (!requiredRole.equals(role)) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().write("403 Forbidden - Insufficient role");
                return false;
            }

            request.setAttribute("username", claims.getSubject());
            request.setAttribute("role", role);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("401 Unauthorized - Invalid token");
            return false;
        }

        return true;
    }
}
