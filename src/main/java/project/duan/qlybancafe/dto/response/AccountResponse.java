package project.duan.qlybancafe.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import project.duan.qlybancafe.model.Role;

import java.util.Set;

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
