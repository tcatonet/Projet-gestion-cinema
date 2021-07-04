package com.under.demo.security.database.Modele;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "User_model")
@Data
@Accessors(chain = true)
public class User {

        @SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="account_id_seq", name="account_id_seq")
        @GeneratedValue(generator="account_id_seq", strategy=GenerationType.SEQUENCE)
        @Id
        @Column(name="id")
        private long id;

        @Column(name="name")
        private String name;

        @Column(name="email")
        private String email;

        @Column(name="password")
        private String password;

        @Column(name="capital")
        private float capital;

        //@OneToMany
        @ElementCollection()
        @JoinTable(name="User_roles", joinColumns=@JoinColumn(name = "user_id"))
        private List<String> roles = new ArrayList();

        public User(String name, String email, String password) {

            this.name = name;
            this.email = email;
            this.password = password;
            this.capital = 0;
        }

        public User() {

        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 79 * hash + Objects.hashCode(this.id);
            hash = 79 * hash + Objects.hashCode(this.name);
            hash = 79 * hash + Objects.hashCode(this.email);
            hash = 79 * hash + Objects.hashCode(this.password);
            hash = 79 * hash + Objects.hashCode(this.capital);
            hash = 79 * hash + Objects.hashCode(this.roles);

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



            final User other = (User) obj;
            if (this.capital != other.capital) {
                return false;
            }
            if (!Objects.equals(this.name, other.name)) {
                return false;
            }

            if (!Objects.equals(this.email, other.email)) {
                return false;
            }

            if (!Objects.equals(this.password, other.password)) {
                return false;
            }

            if (!Objects.equals(this.roles, other.roles)) {
                return false;
            }

            return Objects.equals(this.id, other.id);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("City{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append(", email='").append(email).append('\'');
            sb.append(", password='").append(password).append('\'');
            sb.append(", capital='").append(capital).append('\'');
            sb.append(", roles='").append(roles).append('\'');

            sb.append('}');
            return sb.toString();
        }



}
