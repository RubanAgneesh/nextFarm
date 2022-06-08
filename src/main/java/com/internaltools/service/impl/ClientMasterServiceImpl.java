package com.internaltools.service.impl;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internaltools.util.ErrorConstants;
import com.internaltools.payload.request.ClientMasterRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.persistence.repository.ClientMasterRepository;
import com.internaltools.persistence.repository.CompanyRepository;
import com.internaltools.persistence.repository.CountryRepository;
import com.internaltools.service.ClientMasterService;
import com.internaltools.persistence.entity.ClientMaster;
import com.internaltools.persistence.entity.Company;
import com.internaltools.persistence.entity.Country;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientMasterServiceImpl implements ClientMasterService {

	@Autowired
	private ClientMasterRepository clientMasterRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private CountryRepository countryRepository;
	// Test

	@Override
	public ApiResponse createClientMaster(@Valid ClientMasterRequest request) {
		ApiResponse response = new ApiResponse();

		try {
			if (null == request.getClientMasterModel().getClientName()) {
				response.setMessage("Client Name is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getCompanyRegistrationNo()) {
				response.setMessage("Company Registration Number is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getWebsite()) {
				response.setMessage("Website is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getTelephone()) {
				response.setMessage("Telephone Number is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getIndustry()) {
				response.setMessage("Industry is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getClientAddress1()) {
				response.setMessage("Address1 is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getClientAddress2()) {
				response.setMessage("Address2 is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getClientCity()) {
				response.setMessage("Client City is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getClientState()) {
				response.setMessage("Client State is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getClientZipCode()) {
				response.setMessage("ZipCode is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getGstIn()) {
				response.setMessage("Gst is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getServices()) {
				response.setMessage("Service is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getContactName()) {
				response.setMessage("ContactName is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getContactDesignation()) {
				response.setMessage("Designation is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			if (null == request.getClientMasterModel().getContactEmail()) {
				response.setMessage("Contact Email is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			
			if (null == request.getClientMasterModel().getContactTelephone()) {
				response.setMessage("Contact TelephoneNo is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			
			if (null == request.getClientMasterModel().getPanNumber()) {
				response.setMessage("Pan Number is mandatory");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			
			ClientMaster clientMaster = new ClientMaster();

			clientMaster.setClientName(request.getClientMasterModel().getClientName());

			clientMaster.setCompanyRegistrationNo(request.getClientMasterModel().getCompanyRegistrationNo());

			clientMaster.setWebsite(request.getClientMasterModel().getWebsite());

			clientMaster.setTelephone(request.getClientMasterModel().getTelephone());

			clientMaster.setIndustry(request.getClientMasterModel().getIndustry());

			clientMaster.setClientAddress1(request.getClientMasterModel().getClientAddress1());

			clientMaster.setClientAddress2(request.getClientMasterModel().getClientAddress2());

			clientMaster.setClientCity(request.getClientMasterModel().getClientCity());

			clientMaster.setClientState(request.getClientMasterModel().getClientState());

			clientMaster.setClientZipCode(request.getClientMasterModel().getClientZipCode());

			clientMaster.setGstIn(request.getClientMasterModel().getGstIn());

			clientMaster.setServices(request.getClientMasterModel().getServices());

			clientMaster.setContactName(request.getClientMasterModel().getContactName());

			clientMaster.setContactDesignation(request.getClientMasterModel().getContactDesignation());

			clientMaster.setContactEmail(request.getClientMasterModel().getContactEmail());

			clientMaster.setContactTelephone(request.getClientMasterModel().getContactTelephone());

			clientMaster.setPanNumber(request.getClientMasterModel().getPanNumber());

			Optional<Company> companyOpt = companyRepository.findById(request.getClientMasterModel().getCompanyId());
			if (companyOpt.isEmpty()) {
				response.setMessage("Invalied Company name");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			Company company = companyOpt.get();
			clientMaster.setCompany(company);
			Optional<Country> countryOpt = countryRepository.findById(request.getClientMasterModel().getCountryId());
			if (countryOpt.isEmpty()) {
				response.setMessage("Invalied Country name");
				response.setStatus(Boolean.FALSE);
				response.setStatusCode(ErrorConstants.ERROR_CODE_401);
				return response;
			}
			Country country = countryOpt.get();
			clientMaster.setCountry(country);
			clientMasterRepository.save(clientMaster);
		} catch (Exception e) {
			log.error("Exception in createClientMaster :: " + e.getMessage());
			response.setStatus(false);
			response.setMessage("Failure");
			response.setStatusCode(ErrorConstants.ERROR_CODE_401);
			return response;
		}

		response.setStatus(true);
		response.setMessage("Success");
		response.setStatusCode(ErrorConstants.ERROR_CODE_200);
		return response;

	}

}
