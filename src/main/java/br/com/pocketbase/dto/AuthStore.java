package br.com.pocketbase.dto;

import br.com.pocketbase.generic.RecordModel;
import java.util.stream.Stream;

/**
 *
 * @author gilmario
 */
public class AuthStore {

    private String token;
    private RecordModel record;

    public Stream<AuthStoreEvent> onChange;

    public boolean isValid() {
        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            return false;
        }

//        String tokenPart = Base64.normalize(parts[1]);
//    final data = jsonDecode(utf8.decode(base64Decode(tokenPart)))
//        as Map<String, dynamic>;
//
//    final exp = data["exp"] is int
//        ? data["exp"] as int
//        : (int.tryParse(data["exp"].toString()) ?? 0);
//
//    return exp > (DateTime.now().millisecondsSinceEpoch / 1000);
        return false;
    }


/// Saves the provided [newToken] and [newRecord] auth data into the store.
//  void save(String newToken, RecordModel? newRecord) {
//    _token = newToken;
//    _record = newRecord;
//
//    _onChangeController.add(AuthStoreEvent(token, newRecord));
//  }
//
//  /// Clears the previously stored [token] and [record] auth data.
//  void clear() {
//    _token = "";
//    _record = null;
//
//    _onChangeController.add(AuthStoreEvent(token, record));
//  }
}
