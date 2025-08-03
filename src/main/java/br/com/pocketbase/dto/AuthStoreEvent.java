package br.com.pocketbase.dto;

import br.com.pocketbase.generic.RecordModel;

/**
 *
 * @author gilmario
 */
public record AuthStoreEvent(String token, RecordModel record) {

}
