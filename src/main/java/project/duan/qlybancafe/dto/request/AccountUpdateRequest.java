package project.duan.qlybancafe.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class AccountUpdateRequest {

    @Size(min = 4, message = "USERNAME_INVALID")
    String username;

    String displayName;

    List<String> roles;
}
