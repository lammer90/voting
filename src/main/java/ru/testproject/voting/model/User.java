package ru.testproject.voting.model;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends AbstractNamedEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Vote> votes;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<Role> roles;

    @Column(name = "password")
    @NotBlank
    @Size(min = 4, max = 100)
    private String password;

    @Column(name = "registered")
    @NotNull
    private LocalDate registered = LocalDate.now();

    public User() {
    }

    public User(String name, String password, Set<Role> roles) {
        super(name);
        this.roles = roles;
        this.password = password;
    }

    public User(Integer id, String name, String password, Set<Role> roles) {
        super(id, name);
        this.roles = roles;
        this.password = password;
    }

    public User(String name, String password, Role... roles) {
        super(name);
        this.roles = Set.of(roles);
        this.password = password;
    }

    public User(Integer id, String name, String password, Role... roles) {
        super(id, name);
        this.roles = Set.of(roles);
        this.password = password;
    }

    public User(User user) {
        super(user.getId(), user.getName());
        this.roles = user.getRoles();
        this.password = user.getPassword();
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
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
