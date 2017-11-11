package service;

import com.greenfox.nezihcihanp2p.model.Log;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class Logger {

    public static void showLog(HttpServletRequest request, String parameter) {
        new Log(request.getRequestURI(), request.getMethod(), parameter).showLog();
    }

    public static void showLogNoParam(HttpServletRequest request) {
        new Log(request.getRequestURI(), request.getMethod()).showLog();
    }
}
