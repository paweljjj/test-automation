package com.pawel.automation.jsonplaceholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Posts {

    private int userId;
    private int id;
    private String title;
    private String body;

}
