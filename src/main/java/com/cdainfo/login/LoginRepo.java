package com.cdainfo.login;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class LoginRepo implements ILoginRepo {
    public String authenticate(String username, String password){
        throw new NotImplementedException();
    }

    public boolean isUserInBlackList(String username) {
        throw new NotImplementedException();
    }
}
