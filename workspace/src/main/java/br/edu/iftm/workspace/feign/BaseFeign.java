package br.edu.iftm.workspace.feign;

import br.edu.iftm.workspace.feign.feignDTO.BaseFeignForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "base-client", primary = false)
public interface BaseFeign {

    @PostMapping(value = "/base")
    BaseFeignForm saveBase(@RequestBody BaseFeignForm baseFeignForm);
}
