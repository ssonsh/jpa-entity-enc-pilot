package com.ssonsh.encpilot.domain;

import com.ssonsh.encpilot.enc.Encryptor;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Slf4j
public class MemberEntityListener {

    @PrePersist
    public void prePersist(Member member) {
        log.info("[Member][prePersist] : {}", member);
        Encryptor encryptor = new Encryptor();
        member.encrypt(encryptor);
    }

    @PostPersist
    public void postPersist(Member member) {
        log.info("[Member][postPersist] : {}", member);
    }

    @PreUpdate
    public void preUpdate(Member member) {
        log.info("[Member][preUpdate] : {}", member);
    }

    @PostUpdate
    public void postUpdate(Member member) {
        log.info("[Member][postUpdate] : {}", member);
    }

    @PostLoad
    public void postLoad(Member member) {
        log.info("[Member][postLoad] : {}", member);
        Encryptor encryptor = new Encryptor();
        member.decrypt(encryptor);
    }
}
