package com.lvg.springtest.services;

import com.lvg.springtest.models.ContactSummary;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface ContactSummaryService {
    List<ContactSummary> findAll();
    void displayAllContactSummary();
}
