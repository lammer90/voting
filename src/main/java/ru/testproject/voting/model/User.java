package ru.testproject.voting.model;

import java.util.Date;
import java.util.Set;

public class User extends AbstractNamedEntity{
    private Set<Role> roles;

    private String password;

    private Date registered = new Date();

    public User() {
    }

    public User(String name, Set<Role> roles, String password, Date registered) {
        super(name);
        this.roles = roles;
        this.password = password;
        this.registered = registered;
    }

    public User(Integer id, String name, Set<Role> roles, String password, Date registered) {
        super(id, name);
        this.roles = roles;
        this.password = password;
        this.registered = registered;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "User{" +
                "roles=" + roles +
                ", password='" + password + '\'' +
                ", registered=" + registered +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
