package org.app.base.domain;

public class User {
    private String id;

    private String gid;

    private String username;

    private String password;

    private String fullname;

    private String enableIp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public String getEnableIp() {
        return enableIp;
    }

    public void setEnableIp(String enableIp) {
        this.enableIp = enableIp == null ? null : enableIp.trim();
    }
}