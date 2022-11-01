package com.internaltools.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ImageResponse extends ApiResponse {

    private static final long serialVersionUID = 1L;

    private String imagePath;

    private String imageKey;

}
