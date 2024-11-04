package com.doosane.lec.abstractPrac.httpServlet;

// LoginDownloadServlet 클래스
class LoginDownloadServlet extends com.doosane.lec.abstractPrac.httpServlet.HttpServlet {
    @Override
    public void service() {
        System.out.println("Login success~!");
    }
}

// FileDownloadServlet 클래스
class FileDownloadServlet extends com.doosane.lec.abstractPrac.httpServlet.HttpServlet {
    @Override
    public void service() {
        System.out.println("File download success~!");
    }
}

// HttpServletExample 클래스
public class HttpServletExample {
    public static void main(String[] args) {
        method(new LoginDownloadServlet()); // 로그인 합니다.
        method(new FileDownloadServlet()); // 파일 다운로드 합니다.
    }

    public static void method(com.doosane.lec.abstractPrac.httpServlet.HttpServlet servlet) {
        servlet.service();
    }
}