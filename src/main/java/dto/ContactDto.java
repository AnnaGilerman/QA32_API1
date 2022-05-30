package dto;

import lombok.*;

// "address": "string",
//         "description": "string",
//         "email": "string",
//         "id": 0,
//         "lastName": "string",
//         "name": "string",
//         "phone": "string"
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class ContactDto {
    String address;
    String description;
    String email;
    int id;
    String lastName;
    String name;
    String phone;
}
