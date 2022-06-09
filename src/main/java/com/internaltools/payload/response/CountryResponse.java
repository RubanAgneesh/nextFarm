package com.internaltools.payload.response;

import com.internaltools.service.model.CountryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CountryResponse extends ApiResponse{

    private List<CountryModel> CountryModelList;

}
