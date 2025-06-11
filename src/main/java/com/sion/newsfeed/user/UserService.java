package com.sion.newsfeed.user;

import com.sion.newsfeed.user.dto.GetUserResponseDto;
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

}
