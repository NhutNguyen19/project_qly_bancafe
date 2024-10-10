package project.duan.qlybancafe.dto.response;

import java.util.Set;

import lombok.*;
import lombok.experimental.FieldDefaults;
import project.duan.qlybancafe.model.Role;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    String id;
    String username;
    String password;
    String displayName;
    Set<Role> roles;
}
