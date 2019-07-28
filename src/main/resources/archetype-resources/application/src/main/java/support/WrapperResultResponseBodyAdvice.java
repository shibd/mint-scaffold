package ${package}.support;

import com.dfocus.mint.web.rsp.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

/** 统一包装返回值 */
@RequiredArgsConstructor
@ControllerAdvice
public class WrapperResultResponseBodyAdvice implements ResponseBodyAdvice {

    private final ObjectMapper objectMapper;

    private final List<HandlerFilter> filterList;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        final List<HandlerFilter> filterList = this.filterList;
        if (filterList != null) {
            for (HandlerFilter handlerFilter : filterList) {
                if (handlerFilter.ignored(returnType)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        final Response returnValue;
        if (returnType.getParameterType().equals(void.class)) {
            returnValue = Response.success("");
        }
        else if (Response.class.isAssignableFrom(returnType.getParameterType())) {
            returnValue = (Response) body;
        }
        else {
            returnValue = Response.success(body);
        }

        if (body instanceof String) {
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
            try {
                return this.objectMapper.writeValueAsString(returnValue);
            }
            catch (JsonProcessingException e) {
                throw new HttpMessageNotWritableException("Could not write JSON:" + e.getOriginalMessage(), e);
            }
        }
        return returnValue;
    }

    /**
     * 统一返回值包装过滤接口，用于过滤某些不需要包装的响应。例如：Swagger、Actuator等
     */
    @FunctionalInterface
    public interface HandlerFilter {

        /**
         * 是否忽略特定类型的返回值类型
         * @param returnType 返回值类型
         * @return 忽略返回True 否则返回False
         */
        boolean ignored(MethodParameter returnType);

    }

}
