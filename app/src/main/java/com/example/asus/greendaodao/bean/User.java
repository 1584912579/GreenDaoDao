package com.example.asus.greendaodao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Created by asus on 2018/5/11.
 */
@Entity(nameInDb = "t_user")
public class User {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "t_name")
    private String name;
    @Property
    private String age;
    @Transient
    private String agent;

    @Generated(hash = 1666193281)
    public User(Long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                +
                        '}';
    }
}
