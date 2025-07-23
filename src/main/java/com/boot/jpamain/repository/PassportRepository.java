package com.boot.jpamain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpamain.entity.Passport;
import com.boot.jpamain.entity.PassportId;

public interface PassportRepository extends JpaRepository<Passport, PassportId> {

}
