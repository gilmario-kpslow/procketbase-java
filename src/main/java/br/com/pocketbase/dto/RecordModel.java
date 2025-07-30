package br.com.pocketbase.dto;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class RecordModel {

    private String id;
    private String collectionId;
    private String collectionName;

    private LocalDateTime created;
    private LocalDateTime updated;

    private Map<String, Object> data;
    Map<String, List<RecordModel>> expand = new HashMap<>();
    private List<String> singleExpandKeys = Collections.EMPTY_LIST;
    private List<String> multiExpandKeys = Collections.EMPTY_LIST;

}
