package io.pivotal.pal.tracker;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    public String port="";
    public String memory_limit="";
    public String cf_index_instance="";

    public String cf_instance_addr="";

    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memory_limit,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}") String cf_index_instance,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}") String cf_instance_addr){

        this.port=port;
        this.memory_limit=memory_limit;
        this.cf_index_instance=cf_index_instance;
        this.cf_instance_addr=cf_instance_addr;

    }
    @GetMapping("/env")
    public Map<String, String> getEnv(){
        HashMap<String, String> env = new HashMap<String, String>();
        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memory_limit);
        env.put("CF_INSTANCE_INDEX", cf_index_instance);
        env.put("CF_INSTANCE_ADDR", cf_instance_addr);

        return env;




    }
}
