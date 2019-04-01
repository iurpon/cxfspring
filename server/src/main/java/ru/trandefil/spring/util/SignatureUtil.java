package ru.trandefil.spring.util;

import ru.trandefil.spring.enums.Role;
import ru.trandefil.spring.exception.SecurityAuthentificationException;
import ru.trandefil.spring.model.Session;

import java.util.logging.Logger;
import java.util.stream.IntStream;

public class SignatureUtil {

    private static Logger logger = Logger.getLogger(SignatureUtil.class.getName());

    private static String generateSignature(final String allFields) {
        logger.info("====================================================genarate signature");
        logger.info("====================================================allFiels " + allFields);
/*        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream("src/main/webapp/resources/prop.properties")) {
            logger.info("==================================================== properties  read. inputStream : " + inputStream);
            final Properties properties = new Properties();
            properties.load(inputStream);


        } catch (Exception e) {
            e.printStackTrace();
        }*/
        logger.info("==================================================== properties  load");
        final String salt = "SALT";//properties.getProperty("salt");
        logger.info("==================================================== properties  salt read");
        final int cycle = 564;//Integer.parseInt(properties.getProperty("cycle"));
        logger.info("-----------------------------------------generating signa  with salt = " + salt);
        final String superUniqie = getMultiHash(salt, cycle, allFields);
        return superUniqie;
    }

    private static String getMultiHash(final String salt, final int cycle, final String allFields) {
        logger.info("===========================================multi hash");
        final String solted = salt + allFields + salt;
        final String[] str = new String[1];
        str[0] = solted;
        IntStream.range(0, cycle).forEach((i) -> str[0] = HashUtil.hashPassword(str[0]));
        return str[0];
    }

    public static String createSignature(final String id, final String userId, final long timeStamp, final Role role) {
        logger.info("======================================== creating signature");
        final String sessionFields = id + userId + timeStamp + role.name();
        return generateSignature(sessionFields);
    }

    public static boolean checkCorrectSession(Session session) {
        if (session == null) {
            logger.info("======================================session is null");
            throw new SecurityAuthentificationException("bad security.");
        }
        if (session.getId() == null) {
            logger.info("======================================session.getId is null");
            throw new SecurityAuthentificationException("bad security.");
        }
        if (session.getRole() == null) {
            logger.info("======================================session.getRole is null");
            throw new SecurityAuthentificationException("bad security.");
        }
        if (session.getUserId() == null) {
            logger.info("======================================session.getUserId is null");
            throw new SecurityAuthentificationException("bad security.");
        }
        if (session.getTimestamp() == 0) {
            logger.info("======================================session.getTimestamp is null");
            throw new SecurityAuthentificationException("bad security.");
        }
        if (session.getSignature() == null) {
            logger.info("======================================session.getSignature is null");
            throw new SecurityAuthentificationException("bad security.");
        }
        return session.getSignature().equals(createSignature(session.getId(),
                session.getUserId(), session.getTimestamp(), session.getRole()));
    }

}
