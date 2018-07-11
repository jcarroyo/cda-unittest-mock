package com.cdainfo.login;

public interface ILoginRepo {
    public String authenticate(String username, String password);
    public boolean isUserInBlackList(String username);
}
