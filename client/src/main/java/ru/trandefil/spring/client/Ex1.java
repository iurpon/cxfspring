package ru.trandefil.spring.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class SessionHandler implements Handler<SOAPMessageContext> {
    private static String sessionCookie = null;
    private static final String SET_COOKIE = "Set-Cookie";
    private static final String COOKIE = "Cookie";
    private static final String JSESSIONID = "JSESSIONID";
    private static Pattern cookiePattern =
            Pattern.compile("([^\\p{Cntrl}\\s]+)=(\\w+|\".*\").*");

    private Log log = LogFactory.getLog(SessionHandler.class);

    public void close(MessageContext messageContext) {

    }

    public boolean handleFault(SOAPMessageContext messageContext) {
        return false;
    }

    public boolean handleMessage(SOAPMessageContext messageContext) {
        if (((Boolean)
                messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)))
            return handleOutMessage(messageContext);
        else
            return handleInMessage(messageContext);
    }

    private boolean handleOutMessage(SOAPMessageContext messageContext) {
        @SuppressWarnings("unchecked")
        Map<String, List<String>> headers = (Map<String, List<String>>)
                messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
        if (sessionCookie != null) {
            if (headers == null) {
                headers = new HashMap<String, List<String>>();
                messageContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
            }
            List<String> cookie = headers.get(COOKIE);
            if (cookie == null) {
                cookie = new ArrayList<String>();
                headers.put(COOKIE, cookie);
            }
            cookie.add(sessionCookie);
            log.debug("Cookie added to HTTP Header: " + sessionCookie);
        }
        return true;
    }

    private boolean handleInMessage(SOAPMessageContext messageContext) {
        @SuppressWarnings("unchecked")
        Map<String, List<String>> headers = (Map<String, List<String>>)
                messageContext.get(MessageContext.HTTP_RESPONSE_HEADERS);
        if (headers != null) {
            List<String> setCookie = headers.get(SET_COOKIE);
            if (setCookie != null) {
                for (String cookie : setCookie) {
                    Matcher cookieMatcher = cookiePattern.matcher(cookie);
                    if (cookieMatcher.find()) {
                        String name = cookieMatcher.group(1);
                        String value = cookieMatcher.group(2);
                        if (name.toUpperCase().equals(JSESSIONID)) {
                            sessionCookie = name + '=' + value;
                            log.debug("Cookie retrieved from HTTP Header:" + sessionCookie);
                        }
                    }
                }
            }
        }
        return true;
    }
}
