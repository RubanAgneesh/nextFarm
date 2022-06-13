package com.internaltools.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internaltools.util.ErrorConstants;

import ch.qos.logback.core.net.server.Client;

import com.internaltools.payload.request.ClientMasterRequest;
import com.internaltools.payload.response.ApiResponse;
import com.internaltools.persistence.repository.ClientMasterRepository;
import com.internaltools.persistence.repository.CompanyRepository;
import com.internaltools.persistence.repository.CountryRepository;
import com.internaltools.service.ClientMasterService;
import com.internaltools.service.model.ClientMasterModel;
import com.internaltools.service.model.CompanyModel;
import com.internaltools.service.model.CountryModel;
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

	/**
	 *
	 */
	@Override
	public List<ClientMasterModel> getClientList() {
		// Fetch all the clients from DB through repository
		List<ClientMaster> clientMasterList = clientMasterRepository.findAll();
		List<ClientMasterModel> clientModelList = new ArrayList<>();

		for (ClientMaster client : clientMasterList) {
			ClientMasterModel clientMasterModel = new ClientMasterModel();
			clientMasterModel.setClientName(client.getClientName());
			clientMasterModel.setClientCode(client.getClientCode());
			clientMasterModel.setCompanyRegistrationNo(client.getCompanyRegistrationNo());
			clientMasterModel.setWebsite(client.getWebsite());
			clientMasterModel.setTelephone(client.getTelephone());
			clientMasterModel.setIndustry(client.getIndustry());
			clientMasterModel.setClientAddress1(client.getClientAddress1());
			clientMasterModel.setClientAddress2(client.getClientAddress2());
			clientMasterModel.setClientCity(client.getClientCity());
			clientMasterModel.setClientState(client.getClientState());
			clientMasterModel.setClientZipCode(client.getClientZipCode());
			clientMasterModel.setGstIn(client.getGstIn());
			clientMasterModel.setServices(client.getServices());
			clientMasterModel.setContactName(client.getContactName());
			clientMasterModel.setContactDesignation(client.getContactDesignation());
			clientMasterModel.setContactEmail(client.getContactEmail());
			clientMasterModel.setContactTelephone(client.getContactTelephone());
			clientMasterModel.setPanNumber(client.getPanNumber());
			clientMasterModel.setCompanyId(client.getCompany().getCompanyId());
			clientMasterModel.setCountryId(client.getCountry().getCountryId());

			Country country = client.getCountry();
			CountryModel countryModel = new CountryModel();
			countryModel.setCountryName(country.getCountryName());
			countryModel.setCountryId(country.getCountryId());
			countryModel.setCountryCode(country.getCountryCode());
			countryModel.setCurrencyCode(country.getCurrencyCode());
			countryModel.setCurrencySymbol(country.getCurrencySymbol());
			countryModel.setTimeZone(country.getTimeZone());
			countryModel.setFinancialYearFrom(country.getFinancialYearFrom());
			countryModel.setFinancialYearTo(country.getFinancialYearTo());
			countryModel.setCreatedDate(country.getCreatedDate());
			countryModel.setModifiedDate(country.getModifiedDate());
			clientMasterModel.setCountry(countryModel);

			Company company = client.getCompany();
			CompanyModel companyModel= new CompanyModel();
			companyModel.setCompanyId(company.getCompanyId());
			companyModel.setCompanyName(company.getCompanyName());
			companyModel.setCompanyCode(company.getCompanyCode());
			companyModel.setWebsite(company.getWebsite());
			companyModel.setStartDate(company.getStartDate());
			companyModel.setPanNumber(company.getPanNumber());
			companyModel.setGstin(company.getGstin());
			companyModel.setWebsite(company.getWebsite());
			companyModel.setStartDate(company.getStartDate());
			companyModel.setPanNumber(company.getPanNumber());
			companyModel.setGstin(company.getGstin());
			companyModel.setTelephoneNumber(company.getTelephoneNumber());
			companyModel.setRegisterationNumber(company.getRegisterationNumber());
			companyModel.setServices(company.getServices());
			companyModel.setBankDetails(company.getBankDetails());
			companyModel.setAddressDetails(company.getAddressDetails());
			companyModel.setInvoicePrefix(company.getInvoicePrefix());
			companyModel.setBankName(company.getBankName());
			companyModel.setIfscCode(company.getIfscCode());
			companyModel.setBranchName(company.getBranchName());
			companyModel.setAccountHolderName(company.getAccountHolderName());
			companyModel.setAccountNumber(company.getAccountNumber());
			companyModel.setContactAddressDetails(company.getAddressDetails());
			companyModel.setReenterAccountNumber(company.getReenterAccountNumber());
			companyModel.setSwiftCode(company.getSwiftCode());
			companyModel.setContactAddress1(company.getContactAddress1());
			companyModel.setContactAddress2(company.getContactAddress2());
			companyModel.setContactCountry(company.getContactCountry());
			companyModel.setContactCity(company.getContactCity());
			companyModel.setContactState(company.getContactState());
			companyModel.setContactZipCode(company.getContactZipCode());
			companyModel.setIsBilling(company.getIsBilling());
			companyModel.setContactName(company.getContactName());
			companyModel.setContactDesignation(company.getContactDesignation());
			companyModel.setContactEmailId(company.getContactEmailId());
			companyModel.setContactPhoneNumber(company.getContactPhoneNumber());
			companyModel.setCompanyAddress1(company.getCompanyAddress1());
			companyModel.setCompanyAddress2(company.getCompanyAddress2());
			companyModel.setCompanyCity(company.getCompanyCity());
			companyModel.setCompanyCountry(company.getCompanyCountry());
			companyModel.setCompanyState(company.getCompanyState());
			companyModel.setCompanyZipCode(company.getCompanyZipCode());
			companyModel.setPrimaryAddress(company.getPrimaryAddress());
			clientMasterModel.setCompany(companyModel);
			
			clientModelList.add(clientMasterModel);

		}

		return clientModelList;
	}
}
