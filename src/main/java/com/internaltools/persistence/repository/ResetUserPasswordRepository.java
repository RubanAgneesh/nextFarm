package com.internaltools.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internaltools.persistence.entity.ResetUserPassword;


public interface ResetUserPasswordRepository extends JpaRepository<ResetUserPassword, Long> {

	/**
	 * @param userId
	 * @return List<Optional<ResetUserPassword>> 
	 */
	List<Optional<ResetUserPassword>> findByUserId(Long userId);


	/**
	 * @param otp
	 * @param otpValid
	 * @return Optional<ResetUserPassword>
	 */
	Optional<ResetUserPassword> findByOtpAndOtpValidAndUserUserEmailId(Integer otp, boolean otpValid,String email);
}
