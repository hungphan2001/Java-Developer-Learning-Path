package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private int id;
    @Column(name = "youtube_channel")
    private String yourChannel;

    @Column(name = "hobby")
    private String hobby;
    public InstructorDetail(){

    }

    public InstructorDetail(String yourChannel, String hobby) {
        this.yourChannel = yourChannel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYourChannel() {
        return yourChannel;
    }

    public void setYourChannel(String yourChannel) {
        this.yourChannel = yourChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", yourChannel='" + yourChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
