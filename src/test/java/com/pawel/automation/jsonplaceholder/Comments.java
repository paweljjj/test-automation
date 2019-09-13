package com.pawel.automation.jsonplaceholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comments {

    private int postId;
    private String name;
    private String email;
    private String body;

}
