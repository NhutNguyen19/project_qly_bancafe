package project.duan.qlybancafe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import project.duan.qlybancafe.dto.request.AccountCreationRequest;
import project.duan.qlybancafe.dto.request.AccountUpdateRequest;
import project.duan.qlybancafe.dto.response.AccountResponse;
import project.duan.qlybancafe.model.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toAccount(AccountCreationRequest request);

    AccountResponse toAccountResponse(Account account);

    @Mapping(target = "roles", ignore = true)
    void updateAccount(@MappingTarget Account account, AccountUpdateRequest request);
}
