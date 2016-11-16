package com.lvg.springtest.beans.auditors;

import org.springframework.data.domain.AuditorAware;

/**
 *
 * @author Victor
 */
public class AuditorAwareBean implements AuditorAware<String>{

    @Override
    public String getCurrentAuditor() {
        return "lvg";
    }
    
}
