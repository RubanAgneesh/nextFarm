package com.internaltools.payload.response;

import com.internaltools.service.model.TaxModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxResponse extends ApiResponse {

    private List<TaxModel> TaxModelList;
}
