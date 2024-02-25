package entity;

import java.util.Objects;

/**
 *
 * @author Atuandev
 */
public class TaiKhoan {

    private String id;
    private String username;
    private String password;
    private String role;

    public TaiKhoan() {
    }

    public TaiKhoan(String id) {
        this.id = id;
    }

    public TaiKhoan(String id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaiKhoan other = (TaiKhoan) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + '}';
    }

}
