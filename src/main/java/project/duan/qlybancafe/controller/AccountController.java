package project.duan.qlybancafe.controller;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.shaded.com.google.protobuf.Api;
import org.springframework.web.bind.annotation.*;
import project.duan.qlybancafe.dto.ApiResponse;
import project.duan.qlybancafe.dto.request.AccountCreationRequest;
import project.duan.qlybancafe.dto.request.AccountUpdateRequest;
import project.duan.qlybancafe.dto.response.AccountResponse;
import project.duan.qlybancafe.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AccountController {
    AccountService accountService;

    @PostMapping("/registration")
    ApiResponse<AccountResponse> createAccount(@RequestBody @Valid AccountCreationRequest request){
        return ApiResponse.<AccountResponse>builder()
                .result(accountService.createAccount(request))
                .message("Successfully created account")
                .build();
    }

    @GetMapping()
    ApiResponse<List<AccountResponse>> getAllAccounts(){
        return ApiResponse.<List<AccountResponse>>builder()
                .result(accountService.getAllAccounts())
                .message("Successfully retrieved all accounts")
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<AccountResponse> getAccountById(@PathVariable("id") String id){
        return ApiResponse.<AccountResponse>builder()
                .result(accountService.getAccountById(id))
                .message("Successfully retrieved account")
                .build();
    }

    @GetMapping("/my-info")
    ApiResponse<AccountResponse> getMyInfo(){
        return ApiResponse.<AccountResponse>builder()
                .result(accountService.getMyInfo())
                .message("Successfully retrieved my info")
                .build();
    }

    @PutMapping("/{id}")
    ApiResponse<AccountResponse> updateAccount(@RequestBody @Valid AccountUpdateRequest request, @PathVariable String id){
        return ApiResponse.<AccountResponse>builder()
                .result(accountService.updateAccount(request, id))
                .message("Successfully updated account")
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<AccountResponse> deleteAccount(@PathVariable String id){
        accountService.deleteAccount(id);
        return ApiResponse.<AccountResponse>builder()
                .message("Successfully deleted account")
                .build();
    }
}
