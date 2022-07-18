package com.briansdigital.p1TmocRunRanker.tmocker;

import javax.persistence.*;

@Entity
public class Tmocker {
    @Id
    @SequenceGenerator(
            name="tmocker_sequence",
            sequenceName = "tmocker_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tmocker_sequence"
    )
        private Long id;
        private String name;
        private String email;
        //  private LocalDate dob;
        // @Transient
        // private Integer age;
        // private LocalDateTime startTime;

        public Tmocker() {}

        public Tmocker(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        //  this.dob = dob;
    }

    public Tmocker(String name, String email) {
        this.name = name;
        this.email = email;
        // this.dob = dob;
    }

    public Long getId() {
            return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public LocalDate getDob() {
//        return dob;
//    }
//
//    public void setDob(LocalDate dob) {
//        this.dob = dob;
//    }

//    public Integer getAge() {
//
//        return Period.between(dob, LocalDate.now()).getYears();
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }

    @Override
    public String toString() {
        return "Tmocker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
//                ", dob=" + dob +
//                ", age=" + age +
                '}';
    }
}
