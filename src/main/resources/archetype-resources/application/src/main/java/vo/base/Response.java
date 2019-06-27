package ${package}.vo.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.slf4j.MDC;

@Data
public class Response<T> {

    private final String traceId = MDC.get("X-B3-TraceId");

    @JsonProperty("status")
    protected int status = 0;

    @JsonProperty("message")
    protected String message = "调用成功";

    private Page page;

    private T data;

    protected Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    protected Response(T data) {
        this.data = data;
    }

    public static Response<Void> error(int errorCode, String errorMessage) {
        return new Response<>(errorCode, errorMessage);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(data);
    }
}
