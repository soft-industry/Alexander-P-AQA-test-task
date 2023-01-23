package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultDTO {

        @JsonProperty("provider")
        public String provider;
        @JsonProperty("title")
        public String title;
        @JsonProperty("url")
        public String url;
        @JsonProperty("brand")
        public String brand;
        @JsonProperty("price")
        public Float price;
        @JsonProperty("unit")
        public String unit;
        @JsonProperty("isPromo")
        public Boolean isPromo;
        @JsonProperty("promoDetails")
        public String promoDetails;
        @JsonProperty("image")
        public String image;

}
