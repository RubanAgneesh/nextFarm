package com.internaltools.payload.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SortOrderProperties {
	
	@ApiModelProperty(dataType = "String", notes = "asc|desc")
	String sortDir;
	
	@ApiModelProperty(dataType = "String", notes = "property according to which the result should be sorted")
	String property;
}
