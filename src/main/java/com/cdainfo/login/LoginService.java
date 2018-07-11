package com.cdainfo.login;

public class LoginService {

    private ILoginRepo repo = null;

    public LoginService(){
        this.repo = new LoginRepo();
    }

    public LoginService(ILoginRepo myrepo){
        this.repo = myrepo;
    }

    public String authenticate(String username, String password){
        if(repo.isUserInBlackList(username)){
            return LoginEnumStatus.BLACKLIST.toString();
        }

        LoginEnumStatus authenticationResultStatus = LoginEnumStatus.valueOf(repo.authenticate(username, password));

        switch (authenticationResultStatus){
            case OK:
                return AuthenticationResultMessage.SuccessLogin;
            case KO:
                return AuthenticationResultMessage.CredentialsError;
            case PENDING_ACTIVATE:
                return AuthenticationResultMessage.PendingActivation;
            case SUSPENDED:
                return AuthenticationResultMessage.SuspendedAccount;
            case EXPIRED_PASSWORD:
                return AuthenticationResultMessage.ExpiredPassword;
        }
        return LoginEnumStatus.KO.toString();
    }


    final static class AuthenticationResultMessage
    {
        public static final String SuccessLogin = "Exito!!!";
        public static final String CredentialsError = "Usuario o Password incorrecto";
        public static final String PendingActivation = "Tu cuenta aun no ha sido activada";
        public static final String SuspendedAccount = "Tu cuenta esta suspendida";
        public static final String ExpiredPassword = "Tu password ha expirado";
    }

}

