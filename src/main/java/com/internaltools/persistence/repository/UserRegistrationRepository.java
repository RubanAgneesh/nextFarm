package com.internaltools.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internaltools.persistence.entity.UserRegistration;


public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long> {

	/**
	 * @param userId
	 * @param otpValid
	 * @return Optional<UserRegistration>
	 */
	Optional<UserRegistration> findByUserIdAndOtpValid(Long userId, boolean otpValid);
	
	/**
	 * @param otp
	 * @param otpValid
	 * @param mobileNumber
	 * @return Optional<UserRegistration>
	 */
	Optional<UserRegistration> findByOtpAndOtpValidAndUserUserEmailId(Integer otp, boolean otpValid,String userEmailId);

	/**
	 * @param id
	 * @return Optional<UserRegistration>
	 */
	Optional<UserRegistration> findByUserId(Long id);

}
