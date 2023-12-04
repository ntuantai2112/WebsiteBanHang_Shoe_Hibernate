package com.example.Asm_Java04.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtil {
    // Tạo và gửi cookie về client để lưu
    public static Cookie add(String name, String value, int hours, HttpServletResponse resp) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(hours * 60 * 60);
        cookie.setPath("/");
        resp.addCookie(cookie);
        return cookie;
    }

    // Đọc giá trị cookie gửi từ client
    public static String get(String name, HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase(name)) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }
}
