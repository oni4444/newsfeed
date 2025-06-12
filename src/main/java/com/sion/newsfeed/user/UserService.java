package com.sion.newsfeed.user;

import com.sion.newsfeed.user.dto.CreateUserRequestDto;
import com.sion.newsfeed.user.dto.GetUserResponseDto;
import com.sion.newsfeed.user.dto.UpdateUserRequestDto;
import com.sion.newsfeed.user.dto.UpdateUserResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    // 속성
    private final UserRepository userRepository;


    // 생성자
    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // 기능
    public void createUserService(CreateUserRequestDto requestDto) {

        // 1. 데이터 준비
        String nickname = requestDto.getNickname();
        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        // 2. 검증 로직



    }

    public GetUserResponseDto getUserService(Long userId) {

        // 1. 데이터 준비
        Optional<User> userOptional = userRepository.findById(userId);

        // 2. 검증로직 작성
        if (userOptional.isPresent()) {
            User foundUser = userOptional.get();
            Long foundUserId = foundUser.getId();
            String foundUserNickname = foundUser.getNickname();
            String foundUserEmail = foundUser.getEmail();
            int status = 200;
            String message = "요청이 성공적으로 처리되었어요!";
            GetUserResponseDto responseDto = new GetUserResponseDto(status, message, foundUserId, foundUserNickname, foundUserEmail);
            return responseDto;
        } else {
            int status = 400;
            String message = "문제가 발생했어요. 다시 시도해 주세요!";
            GetUserResponseDto responseDto = new GetUserResponseDto(status, message, null, null, null);
            return responseDto;
        }

        // 3. 조회

        // 4. responseDto 만들기

        // 5. responseDto 반환
    }

    public UpdateUserResponseDto updateUserService(Long userId, UpdateUserRequestDto requestDto) {

        // 1. 데이터 준비
        String nickname = requestDto.getNickname();

        // 2. 검증로직 작성
        if (nickname == null || nickname.trim().isEmpty()) {
            int status = 400;
            String message = "닉네임을 입력해 주세요!";
            UpdateUserResponseDto responseDto = new UpdateUserResponseDto(status, message);
            return responseDto;
        }

        // 3. 수정할 대상 조회
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User foundUser = userOptional.get();
            String foundUserNickname = foundUser.getNickname();

            foundUser.updateNickname(nickname);

            // 4. 업데이트
            userRepository.save(foundUser);

            // 5. responseDto 만들기
            UpdateUserResponseDto responseDto = new UpdateUserResponseDto(200, "닉네임이 성공적으로 변경되었어요!");

            // 6. responseDto 반환
            return responseDto;

        } else {
            UpdateUserResponseDto responseDto = new UpdateUserResponseDto(404, "사용자를 찾을 수 없어요.");
            return responseDto;
        }


    }

}
