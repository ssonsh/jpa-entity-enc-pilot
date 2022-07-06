package com.ssonsh.encpilot.domain;

import com.ssonsh.encpilot.enc.Encryptor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "member")
@EntityListeners({MemberEntityListener.class})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Member(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public static Member of(String name, String phoneNumber, String emailAddress) {
        return new Member(name, phoneNumber, emailAddress);
    }

    public Long getId() {
        return this.id;
    }

    public void encrypt(Encryptor encryptor) {
        this.name = encryptor.encrypt(this.name);
        this.phoneNumber = encryptor.encrypt(this.phoneNumber);
        this.emailAddress = encryptor.encrypt(this.emailAddress);
    }

    public void decrypt(Encryptor encryptor) {
        this.name = encryptor.decrypt(this.name);
        this.phoneNumber = encryptor.decrypt(this.phoneNumber);
        this.emailAddress = encryptor.decrypt(this.emailAddress);
    }

    public String getName() {
        return this.name;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public String getEmailAddress() {
        return this.emailAddress;
    }

    @Override
    public String toString() {
        return "Member{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", emailAddress='" + emailAddress + '\'' +
               '}';
    }
}
