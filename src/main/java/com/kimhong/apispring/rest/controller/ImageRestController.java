package com.kimhong.apispring.rest.controller;

import com.kimhong.apispring.constant.ApiConstant;
import com.kimhong.apispring.rest.message.SuccessMessage;
import com.kimhong.apispring.rest.response.ApiResponse;
import com.kimhong.apispring.rest.response.ImageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstant.API_VERSION)
public class ImageRestController {

    @Value("${file.upload.server-path}")
    private String serverPath;

    @Value("${app.base-url}")
    private String baseUrl;

    // consumes = Content-Type
    // produces = Accept
    @PostMapping(value = ApiConstant.UPLOAD_IMAGE_URL,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ImageResponse>> uploadImage(
            @RequestParam("image") MultipartFile image
            ){

        ApiResponse<ImageResponse> response = new ApiResponse<>();

        String imageName= "";
        String imageUri = "";
        String originalName = "";
        if (!image.isEmpty()){
            originalName = image.getOriginalFilename();
            if (originalName != null)
            {
                imageName = UUID.randomUUID().toString()
                        + originalName.substring(originalName.lastIndexOf("."));
                imageUri = baseUrl + "/images/" + imageName;
                try {
                    Files.copy(image.getInputStream(), Paths.get(serverPath + imageName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ImageResponse imageResponse = new ImageResponse();

                imageResponse.setName(imageName);
                imageResponse.setUri(imageUri);
                imageResponse.setFileType(image.getContentType());
                imageResponse.setFileSize(image.getSize());
                response.setResponse(SuccessMessage.UPLOADED_IMAGE.value(),
                        true, HttpStatus.CREATED.value(),
                        imageResponse);
                return ResponseEntity.ok(response);
            }
        }
        return null;
    }
}
