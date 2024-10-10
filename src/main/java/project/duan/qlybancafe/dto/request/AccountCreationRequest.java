package project.duan.qlybancafe.dto.request;

import jakarta.validation.constraints.Size;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreationRequest {

    @Size(min = 4, message = "USERNAME_INVALID")
    String username;

    @Size(min = 4, message = "PASSWORD_INVALID")
    String password;

    String displayName;
}
