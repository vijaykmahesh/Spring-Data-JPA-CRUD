package com.boot.jpamain.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boot.jpamain.dto.PassportDTO;
import com.boot.jpamain.entity.Passport;
import com.boot.jpamain.entity.PassportId;
import com.boot.jpamain.mapper.Mapper;
import com.boot.jpamain.repository.PassportRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class PassportService {

	private final PassportRepository passportRepository;
	private final Mapper mapper;
	@PersistenceContext
	private EntityManager entityManager;

	public PassportService(PassportRepository passportRepository, Mapper mapper) {
		super();
		this.passportRepository = passportRepository;
		this.mapper = mapper;
	}

	public PassportDTO getPassportById(String countryCode, String passportNumber) {

		PassportId id = new PassportId();
		id.setCountryCode(countryCode);
		id.setPassportNumber(passportNumber);

		Optional<Passport> byId = passportRepository.findById(id);

		return mapper.toDto(byId.get());

	}

	public void test(String countryCode, String passportNumber) {

		PassportId id = new PassportId();
		id.setCountryCode(countryCode);
		id.setPassportNumber(passportNumber);

		Optional<Passport> byId = passportRepository.findById(id);

		entityManager.clear(); // clears first-level (session) cache

		Optional<Passport> byId2 = passportRepository.findById(id);

	}

}
