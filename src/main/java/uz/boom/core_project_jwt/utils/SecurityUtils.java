package uz.boom.core_project_jwt.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import uz.boom.core_project_jwt.entity.AuthUser;
import uz.boom.core_project_jwt.exception.NotFoundException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

/**
 * @author Jarvis on Sat 11:16. 08/04/23
 */
@UtilityClass
public class SecurityUtils {
    private final String LOCALHOST_IPV4 = "192.168.43.97";
    private final String LOCALHOST_IPV6 = "fe80::99e6:973:3298:d34e";

    public AuthUser getCurrentUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.nonNull(authentication)) {
            return (AuthUser) authentication.getPrincipal();
        }
        throw new NotFoundException("USER NOT FOUND!");
    }

    public String getRequestIpAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress))
            ipAddress = request.getHeader("WL-Proxy-Client-IP");

        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress))
            ipAddress = request.getHeader("Proxy-client-IP");

        if (StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (LOCALHOST_IPV4.equals(ipAddress) || (LOCALHOST_IPV6.equals(ipAddress))) {
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    ipAddress = inetAddress.getHostAddress();
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ipAddress;
    }
}
