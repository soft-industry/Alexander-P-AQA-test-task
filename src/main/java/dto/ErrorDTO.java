package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorDTO {

    @JsonProperty("detail")
    public Detail detail;

    @Data
    public static class Detail {

        @JsonProperty("error")
        public Boolean error;
        @JsonProperty("message")
        public String message;
        @JsonProperty("requested_item")
        public String requestedItem;
        @JsonProperty("served_by")
        public String servedBy;

    }
}
