package com.boot.jpamain.mapper;

import java.time.LocalDateTime;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import com.boot.jpamain.dto.AddressDTO;
import com.boot.jpamain.dto.CourseDTO;
import com.boot.jpamain.dto.PassportDTO;
import com.boot.jpamain.dto.StudentDTO;
import com.boot.jpamain.entity.Address;
import com.boot.jpamain.entity.Course;
import com.boot.jpamain.entity.Passport;
import com.boot.jpamain.entity.PassportId;
import com.boot.jpamain.entity.Student;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

	Student toEntity(StudentDTO dto);

	public StudentDTO toDto(Student student);

	Course toEntity(CourseDTO dto);


	@Mapping(target = "createdBy", source = "createdBy")
	@Mapping(target = "createdDate", source = "createdDate")
	// @Mapping --> Field names are different between source and target.
	@Mapping(source = "student.studentId", target = "studentId") // 🔥 key fix
	CourseDTO toDto(Course entity);

	Address toEntity(AddressDTO dto);

	@Mapping(source = "student.studentId", target = "studentId")
	AddressDTO toDto(Address entity);

	@Mappings({ @Mapping(target = "passportId", source = ".", qualifiedByName = "toPassportId") })
	Passport toEntity(PassportDTO dto);

	@Mapping(target = "passportNumber", source = "passportId.passportNumber")
	@Mapping(target = "countryCode", source = "passportId.countryCode")
	PassportDTO toDto(Passport entity);

	@Named("toPassportId")
	default PassportId toPassportId(PassportDTO dto) {
		if (dto == null)
			return null;
		PassportId id = new PassportId();
		id.setPassportNumber(dto.getPassportNumber());
		id.setCountryCode(dto.getCountryCode());
		return id;
	}

	// 🔥 Modify the mapped entity after basic mapping is done
	@AfterMapping
	default void updateHolderName(@MappingTarget Passport passport, PassportDTO dto) {
		// custom logic to override or set holderName
		passport.setHolderName(dto.getHolderName());
	}

}
