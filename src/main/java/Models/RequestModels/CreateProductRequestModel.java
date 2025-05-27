package Models.RequestModels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;

public class CreateProductRequestModel {
    @JsonProperty("productId")
    public String productName;
    @JsonProperty("productAddedBy")
    public String productAddedBy; // Will be set to userId
    @JsonProperty("productCategory")
    public String productCategory;
    @JsonProperty("productSubCategory")
    public String productSubCategory;
    @JsonProperty("productPrice")
    public int productPrice;
    @JsonProperty("productDescription")
    public String productDescription;
    @JsonProperty("productFor")
    public String productFor;


    // For image upload - not part of JSON body
    @JsonProperty("productImage")
    public transient File productImage; // 'transient' excludes from JSON serialization
}
