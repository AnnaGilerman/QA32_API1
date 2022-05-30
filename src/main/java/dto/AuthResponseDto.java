package dto;

import lombok.*;

//{
//        "token": "string"
//        }
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class AuthResponseDto {
    String token;
}
