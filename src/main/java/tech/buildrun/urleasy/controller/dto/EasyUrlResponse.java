package tech.buildrun.urleasy.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EasyUrlResponse {
    @JsonProperty("url")
    private final String redirectUrl;

    public EasyUrlResponse(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }


    public String getRedirectUrl() {
        return redirectUrl;
    }


    @Override
    public String toString() {
        return "EasyUrlResponse{redirectUrl='" + redirectUrl + "'}";
    }
}