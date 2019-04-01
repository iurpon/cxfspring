package ru.trandefil.spring.endpoint;

//@WebService(endpointInterface = "ru.trandefil.spring.generated.AdminEndPoint")
public class AdminEndPointImpl {//implements AdminEndPoint {

/*    @Autowired
    private AdminService adminService;

    @Override
    @WebMethod
    public void saveJson(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to do this command.");
            throw new SecurityAuthorizationException("not authorized for this operation.");
        }
        adminService.saveJson();
    }

    @Override
    @WebMethod
    public void loadJson(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to do this command.");
            throw new SecurityAuthorizationException("not authorized for this operation.");
        }
        adminService.loadJson();
    }

    @Override
    @WebMethod
    public void clearJson(Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to do this command.");
            throw new SecurityAuthorizationException("not authorized for this operation.");
        }
        adminService.clearJson();
    }*/

}
