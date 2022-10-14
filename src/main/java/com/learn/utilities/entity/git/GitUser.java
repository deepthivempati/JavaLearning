package com.learn.utilities.entity.git;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.learn.utilities.entity.git.supportEntities.Credentials;
import com.learn.utilities.entity.git.supportEntities.Extra;
import com.learn.utilities.entity.git.supportEntities.Info;

import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "provider",
        "uid",
        "info",
        "credentials",
        "extra"
})
@Generated("jsonschema2pojo")
public class GitUser {

    @JsonProperty("provider")
    public String provider;
    @JsonProperty("uid")
    public String uid;
    @JsonProperty("info")
    public Info info;
    @JsonProperty("credentials")
    public Credentials credentials;
    @JsonProperty("extra")
    public Extra extra;

}
